package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AdicionarSaudeObservacaoDto;
import com.project.sp_medical_group.Models.SaudeObservacoes;

import reactor.core.publisher.Mono;

public interface SaudeObservacoesRepository {
    public abstract Mono<SaudeObservacoes> addSaudeObservacao(String pacienteCpf, AdicionarSaudeObservacaoDto adicionarSaudeObservacaoDto);
}
