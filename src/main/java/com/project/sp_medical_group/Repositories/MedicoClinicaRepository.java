package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;

import reactor.core.publisher.Mono;

public interface MedicoClinicaRepository {
    Mono<String> associateMedicoClinica(AssociarMedicoClinicaDto associarMedicoClinicaDto);
}