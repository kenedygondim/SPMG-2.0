package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.ReactiveCrudRepository.ConvenioReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.ConvenioRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConvenioService implements ConvenioRepository {
    private final ConvenioReactiveCrudRepository convenioReactiveCrudRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ConvenioService(ConvenioReactiveCrudRepository convenioReactiveCrudRepository, ObjectMapper objectMapper) {
        this.convenioReactiveCrudRepository = convenioReactiveCrudRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Convenio> createConvenio(@Valid CriarConvenioDto criarConvenioDto) {
        return Mono.fromCallable(() -> objectMapper.convertValue(criarConvenioDto, Convenio.class))
                .onErrorMap(IllegalArgumentException.class, e -> new BusinessException("Erro ao criar converter Dto, verifique os dados enviados: " + e.getMessage()))
                .flatMap(convenio -> convenioReactiveCrudRepository.save(convenio))
                .onErrorMap(DataIntegrityViolationException.class, e -> new BusinessException("Já existe um convênio cadastrado com esse nome: " + e.getMessage()))
                .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar convênio: " + e.getMessage()));
    }

    @Override
    public Flux<Convenio> getAllConvenios() {
        return convenioReactiveCrudRepository.findAll();
    }
}
