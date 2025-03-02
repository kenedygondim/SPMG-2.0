package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;

import reactor.core.publisher.Mono;

public interface MedicoEspecialidadeRepository {
    Mono<String> associateMedicoEspecialidade(AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto);
}
