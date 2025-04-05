package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Models.MedicoEspecialidade;
import com.project.sp_medical_group.Repositories.MedicoEspecialidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoEspecialidadeService implements MedicoEspecialidadeRepository {
    @Override
    public MedicoEspecialidade associateMedicoEspecialidade(AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto) {
        return null;
    }
}
