package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Database.CustomProcedures;
import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.AvaliacaoClinica;
import com.project.sp_medical_group.ReactiveCrudRepository.AvaliacaoClinicaReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.AvaliacaoClinicaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AvaliacaoClinicaService implements AvaliacaoClinicaRepository {

    private final AvaliacaoClinicaReactiveCrudRepository avaliacaoClinicaReactiveCrudRepository;
    private final CustomProcedures customProcedures;
    private final ObjectMapper objectMapper;

    @Autowired
    public AvaliacaoClinicaService(AvaliacaoClinicaReactiveCrudRepository avaliacaoClinicaReactiveCrudRepository,
                                   ObjectMapper objectMapper,
                                   CustomProcedures customProcedures) 
    {
        this.avaliacaoClinicaReactiveCrudRepository = avaliacaoClinicaReactiveCrudRepository;
        this.objectMapper = objectMapper;
        this.customProcedures = customProcedures;
    }

    @Override
    //TO-DO o paciente já avaliou a clínica? Se sim, apenas atualizar a avaliação
    public Mono<AvaliacaoClinica> createAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto) {
        return customProcedures.checaNumeroConsultasPacienteClinica(avaliarClinicaDto.clinicaCnpj(), avaliarClinicaDto.pacienteCpf())
            .flatMap(numeroConsultas -> {
                if (numeroConsultas == 0) {
                    throw new BusinessException("O paciente não possui consultas concluídas nesta clínica");
                }
                return Mono.fromCallable(() -> objectMapper.convertValue(avaliarClinicaDto, AvaliacaoClinica.class));
            })
            .onErrorMap(IllegalArgumentException.class, e -> new BusinessException("Erro ao converter Dto, verifique os dados enviados: " + e.getMessage()))
            .flatMap(avaliacaoClinica -> avaliacaoClinicaReactiveCrudRepository.save(avaliacaoClinica));
    }

    @Override
    public Flux<AvaliacaoClinica> getAllAvaliacoesClinicaByClinicaCnpj(String clinicaCnpj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAvaliacoesClinicaByClinicaCnpj'");
    }

    @Override
    public Flux<AvaliacaoClinica> getAllAvaliacoesClinicaByPacienteCpf(String pacienteCpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAvaliacoesClinicaByPacienteCpf'");
    }


}
