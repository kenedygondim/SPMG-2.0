package com.project.sp_medical_group.Services;

import org.springframework.stereotype.Service;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.ReactiveCrudRepository.MedicoEspecialidadeReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.MedicoEspecialidadeRepository;

import reactor.core.publisher.Mono;

@Service
public class MedicoEspecialidadeService implements MedicoEspecialidadeRepository {
    private final MedicoEspecialidadeReactiveCrudRepository medicoEspecialidadeReactiveCrudRepository;

    public MedicoEspecialidadeService(MedicoEspecialidadeReactiveCrudRepository medicoEspecialidadeReactiveCrudRepository) {
        this.medicoEspecialidadeReactiveCrudRepository = medicoEspecialidadeReactiveCrudRepository;
    }
    
    @Override
    public Mono<String> associateMedicoEspecialidade(AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto) {
        return medicoEspecialidadeReactiveCrudRepository.insertMedicoEspecialidade(associarMedicoEspecialidadeDto.especialidadeId(), associarMedicoEspecialidadeDto.medicoCpf(), associarMedicoEspecialidadeDto.valorProcedimento())
                .thenReturn("Especialidade adicionada ao médico com sucesso!")
                .onErrorMap(Exception.class, error -> new BusinessException("Erro ao associar especialidade ao médico: " + error.getMessage()));
    }
    
}
