package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.ReactiveCrudRepository.EspecialidadeReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.EspecialidadeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EspecialidadeService implements EspecialidadeRepository {
    private final EspecialidadeReactiveCrudRepository especialidadeReactiveCrudRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public EspecialidadeService(EspecialidadeReactiveCrudRepository especialidadeReactiveCrudRepository, ObjectMapper objectMapper) {
        this.especialidadeReactiveCrudRepository = especialidadeReactiveCrudRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Especialidade> createEspecialidade(CriarEspecialidadeDto criarEspecialidadeDto) {
        return Mono.fromCallable(() -> objectMapper.convertValue(criarEspecialidadeDto, Especialidade.class))
            .onErrorMap(IllegalArgumentException.class, e -> new BusinessException("Erro ao converter Dto, verifique os dados enviados: " + e.getMessage()))
            .flatMap(especialidadeReactiveCrudRepository::save)
            .onErrorMap(DataIntegrityViolationException.class, e -> new BusinessException("Erro ao criar especialidade, essa especialidade já está cadastrada no sistema: " + e.getMessage()))
            .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar especialidade: " + e.getMessage()));
    }

    @Override
    public Flux<Especialidade> getAllEspecialidades() {
       return especialidadeReactiveCrudRepository.findAll();
    }

}
