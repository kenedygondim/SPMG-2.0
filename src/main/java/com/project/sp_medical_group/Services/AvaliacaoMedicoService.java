package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Database.CustomProcedures;
import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.AvaliacaoMedico;
import com.project.sp_medical_group.ReactiveCrudRepository.AvaliacaoMedicoReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.AvaliacaoMedicoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AvaliacaoMedicoService implements AvaliacaoMedicoRepository {

    private final AvaliacaoMedicoReactiveCrudRepository avaliacaoMedicoReactiveCrudRepository;
    private final CustomProcedures customProcedures;
    private final ObjectMapper objectMapper;

    @Autowired
    public AvaliacaoMedicoService(AvaliacaoMedicoReactiveCrudRepository avaliacaoMedicoReactiveCrudRepository,
                                   ObjectMapper objectMapper,
                                   CustomProcedures customProcedures) 
    {
        this.avaliacaoMedicoReactiveCrudRepository = avaliacaoMedicoReactiveCrudRepository;
        this.objectMapper = objectMapper;
        this.customProcedures = customProcedures;
    }

    @Override
    //TO-DO o paciente já avaliou a clínica? Se sim, apenas atualizar a avaliação
    public Mono<AvaliacaoMedico> createAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto) {
        Mono<AvaliacaoMedico> avaliacaoMedicoExistente = avaliacaoMedicoReactiveCrudRepository.findByMedicoCpfAndPacienteCpf(avaliarMedicoDto.medicoCpf(), avaliarMedicoDto.pacienteCpf())
            .flatMap(avaliacaoMedico -> { 
                return avaliacaoMedico != null ? Mono.just(avaliacaoMedico) : Mono.empty();
            });

        Mono<Integer> numeroConsultas = customProcedures.checaNumeroConsultasPacienteMedico(avaliarMedicoDto.medicoCpf(), avaliarMedicoDto.pacienteCpf())
            .flatMap(consultasCount -> {
                if (consultasCount == 0) 
                    throw new BusinessException("O paciente não possui consultas concluídas com este médico");
                return Mono.just(consultasCount);
            });    

        return Mono.zip(avaliacaoMedicoExistente.defaultIfEmpty(new AvaliacaoMedico()), numeroConsultas)
            .flatMap(tuple -> {
                // Se a avaliação já existir, atualiza os campos
                if (tuple.getT1().getAvaliacaoId() != null) {
                    tuple.getT1().setComentario(avaliarMedicoDto.comentario());
                    tuple.getT1().setNumeroEstrelas(avaliarMedicoDto.numeroEstrelas());
                    System.out.println("caiu aqui");
                    return avaliacaoMedicoReactiveCrudRepository.save(tuple.getT1());
                }

                System.out.println("caiu aqui 2");
                AvaliacaoMedico avaliacaoMedico = objectMapper.convertValue(avaliarMedicoDto, AvaliacaoMedico.class);
                return avaliacaoMedicoReactiveCrudRepository.save(avaliacaoMedico);
            })
            .onErrorMap(IllegalArgumentException.class, e -> new BusinessException("Erro ao converter Dto, verifique os dados enviados: " + e.getMessage()))
            .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar/atualizar avaliação do médico: " + e.getMessage()));
    }

    @Override
    public Flux<AvaliacaoMedico> getAllAvaliacoesMedicoByMedicoCrm(String clinicaCnpj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAvaliacoesClinicaByClinicaCnpj'");
    }

    @Override
    public Flux<AvaliacaoMedico> getAllAvaliacoesMedicoByPacienteCpf(String pacienteCpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAvaliacoesClinicaByPacienteCpf'");
    }


}
