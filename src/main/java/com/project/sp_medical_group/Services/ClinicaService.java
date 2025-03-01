package com.project.sp_medical_group.Services;

import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.ReactiveCrudRepository.ClinicaReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

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
    @Transactional
    public Mono<String> createClinica(CriarClinicaEnderecoDto criarClinicaEnderecoDto) {
            return enderecoService.createEndereco(criarClinicaEnderecoDto.endereco())
                .flatMap(enderecoCriado -> 
                    clinicaReactiveCrudRepository.insertClinica(criarClinicaEnderecoDto.clinica().cnpj(),
                                                                criarClinicaEnderecoDto.clinica().nomeFantasia(),
                                                                criarClinicaEnderecoDto.clinica().razaoSocial(),
                                                                enderecoCriado.getEnderecoId())
                )
                .thenReturn("Clínica criada com sucesso!")
                .onErrorMap(DuplicateKeyException.class, e -> new BusinessException("Já existe uma clínica cadastrado com esse CNPJ: " + e.getMessage()))
                .onErrorMap(DataIntegrityViolationException.class, e -> new BusinessException("Já existe uma clínica cadastrado com essa razão social ou nome fantasia: " + e.getMessage()))
                .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar clínica: " + e.getMessage()));
    }
}
