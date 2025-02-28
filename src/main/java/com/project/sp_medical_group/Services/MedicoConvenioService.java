package com.project.sp_medical_group.Services;

import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;

import reactor.core.publisher.Mono;

public class MedicoConvenioService implements MedicoConvenioRepository {

    @Override
    public Mono<Void> associateMedicoConvenio(String medicoCrm, Integer convenioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'associateMedicoConvenio'");
    }
    
}
