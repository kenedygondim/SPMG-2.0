package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.ReactiveCrudRepository.ClinicaReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClinicaService implements ClinicaRepository {
    private final ClinicaReactiveCrudRepository clinicaReactiveCrudRepository;
    private final EnderecoService enderecoService;

    @Autowired
    public ClinicaService(ClinicaReactiveCrudRepository clinicaReactiveCrudRepository, EnderecoService enderecoService) {
        this.clinicaReactiveCrudRepository = clinicaReactiveCrudRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public Flux<Clinica> getAllClinicas() {
        return clinicaReactiveCrudRepository.findAll();
    }

    @Override
    public Mono<Clinica> createClinica(CriarClinicaEnderecoDto criarClinicaEnderecoDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Clinica clinica = objectMapper.convertValue(criarClinicaEnderecoDto.clinica(), Clinica.class);
            return enderecoService.createEndereco(criarClinicaEnderecoDto.endereco())
                    .flatMap(enderecoCriado -> {
                        clinica.setEnderecoId(enderecoCriado.getEnderecoId());
                        return clinicaReactiveCrudRepository.save(clinica);
                    });
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma clínica cadastrado com essa razão social ou nome fantasia: " + e.getMessage());
        }
    }

}
