package com.project.sp_medical_group.Repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Models.Disponibilidade;

public interface DisponibilidadeRepository {
    public abstract Mono<Disponibilidade> createDisponibilidade(CriarDisponibilidadeDto criarDisponibilidadeDto);
    public abstract Flux<Disponibilidade> getAllDisponibilidadesByMedicoCpf(String medicoCpf);
}
