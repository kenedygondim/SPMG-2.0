package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.SaudeObservacoes;

public interface SaudeObservacoesReactiveCrudRepository extends ReactiveCrudRepository<SaudeObservacoes, Integer> {
    
}
