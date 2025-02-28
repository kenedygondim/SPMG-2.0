package com.project.sp_medical_group.Repositories;

import reactor.core.publisher.Mono;

public interface MedicoConvenioRepository {
    Mono<Void> associateMedicoConvenio(String medicoCrm, Integer convenioId);
}
