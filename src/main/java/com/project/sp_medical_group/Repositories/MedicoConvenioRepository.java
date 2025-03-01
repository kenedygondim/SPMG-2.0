package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;

import reactor.core.publisher.Mono;

public interface MedicoConvenioRepository {
    Mono<String> associateMedicoConvenio(AssociarMedicoConvenioDto associarMedicoConvenioDto);
}
