package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.AdicionarSaudeObservacaoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.SaudeObservacoes;
import com.project.sp_medical_group.ReactiveCrudRepository.SaudeObservacoesReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.SaudeObservacoesRepository;

import reactor.core.publisher.Mono;

@Service
public class SaudeObservacoesService implements SaudeObservacoesRepository {
    private final SaudeObservacoesReactiveCrudRepository saudeObservacoesReactiveCrudRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public SaudeObservacoesService (SaudeObservacoesReactiveCrudRepository saudeObservacoesReactiveCrudRepository, ObjectMapper objectMapper){
        this.saudeObservacoesReactiveCrudRepository = saudeObservacoesReactiveCrudRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<SaudeObservacoes> addSaudeObservacao(String pacienteCpf, AdicionarSaudeObservacaoDto adicionarSaudeObservacaoDto) {
        return Mono.fromCallable(() -> {
            SaudeObservacoes saudeObservacoes = objectMapper.convertValue(adicionarSaudeObservacaoDto, SaudeObservacoes.class);
            saudeObservacoes.setPacienteCpf(pacienteCpf);
            return saudeObservacoes;
        }) 
        .onErrorMap(IllegalArgumentException.class, e -> new BusinessException("Erro ao converter Dto, verifique os dados enviados: " + e.getMessage()))
        .flatMap(saudeObservacoesReactiveCrudRepository::save)
        .onErrorMap(Exception.class, e -> new BusinessException("Erro ao adicionar observações de saúde: " + e.getMessage()));
    }
}
