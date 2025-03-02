package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Models.Especialidade;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EspecialidadeRepository {
    Mono<Especialidade> createEspecialidade(CriarEspecialidadeDto criarEspecialidadeDto);
    Flux<Especialidade> getAllEspecialidades();
}


