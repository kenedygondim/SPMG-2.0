package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Models.MedicoEspecialidade;

public interface MedicoEspecialidadeRepository {
    public abstract MedicoEspecialidade associateMedicoEspecialidade(AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto);
}
