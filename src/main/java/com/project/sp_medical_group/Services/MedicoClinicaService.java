package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.MedicoClinica;
import com.project.sp_medical_group.ReactiveCrudRepository.MedicoClinicaReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;

import reactor.core.publisher.Mono;

@Service
public class MedicoClinicaService implements MedicoClinicaRepository {
    private final MedicoClinicaReactiveCrudRepository medicoClinicaReactiveCrudRepository;

    @Autowired
    public MedicoClinicaService(MedicoClinicaReactiveCrudRepository medicoClinicaReactiveCrudRepository) {
        this.medicoClinicaReactiveCrudRepository = medicoClinicaReactiveCrudRepository;
    }
    
    @Override
    public Mono<String> associateMedicoClinica(AssociarMedicoClinicaDto associarMedicoClinicaDto) {
        return medicoClinicaReactiveCrudRepository.insertMedicoClinica(associarMedicoClinicaDto.clinicaCnpj(), associarMedicoClinicaDto.medicoCpf())
                .thenReturn("Médico adicionado a clínica com sucesso!")
                .onErrorMap(DuplicateKeyException.class, error -> new BusinessException("Clínica já associada ao médico!"))
                .onErrorMap(Exception.class, error -> new BusinessException("Erro ao associar clínica ao médico: " + error.getMessage()));
    }
    
}
