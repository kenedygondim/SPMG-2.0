package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AdicionarSaudeObservacaoDto;
import com.project.sp_medical_group.Models.SaudeObservacoes;

public interface SaudeObservacoesRepository {
    public abstract SaudeObservacoes addSaudeObservacao(Long pacienteId, AdicionarSaudeObservacaoDto adicionarSaudeObservacaoDto);
}
