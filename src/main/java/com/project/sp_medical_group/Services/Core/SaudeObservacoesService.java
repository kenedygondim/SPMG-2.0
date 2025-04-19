package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AdicionarSaudeObservacaoDto;
import com.project.sp_medical_group.Models.SaudeObservacoes;
import com.project.sp_medical_group.Repositories.SaudeObservacoesRepository;
import org.springframework.stereotype.Service;

@Service
public class SaudeObservacoesService implements SaudeObservacoesRepository {
    @Override
    public SaudeObservacoes addSaudeObservacao(Long pacienteId, AdicionarSaudeObservacaoDto adicionarSaudeObservacaoDto) {
        return null;
    }
}
