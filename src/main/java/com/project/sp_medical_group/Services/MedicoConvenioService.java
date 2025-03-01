package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.ReactiveCrudRepository.MedicoConvenioReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;

import reactor.core.publisher.Mono;

@Service
public class MedicoConvenioService implements MedicoConvenioRepository {
    private final MedicoConvenioReactiveCrudRepository medicoConvenioReactiveCrudRepository;

    @Autowired
    public MedicoConvenioService(MedicoConvenioReactiveCrudRepository medicoConvenioReactiveCrudRepository) {
        this.medicoConvenioReactiveCrudRepository = medicoConvenioReactiveCrudRepository;
    }


    @Override
    public Mono<String> associateMedicoConvenio(AssociarMedicoConvenioDto associarMedicoConvenioDto) {
            return medicoConvenioReactiveCrudRepository.insertMedicoConvenio(associarMedicoConvenioDto.convenioId(), associarMedicoConvenioDto.medicoCpf())
                .thenReturn("Convênio associado ao médico com sucesso!")
                .onErrorMap(DuplicateKeyException.class, error -> new BusinessException("Convênio já associado ao médico!"))
                .onErrorMap(Exception.class, error -> new BusinessException("Erro ao associar convênio ao médico: " + error.getMessage()));
    }
    
}
