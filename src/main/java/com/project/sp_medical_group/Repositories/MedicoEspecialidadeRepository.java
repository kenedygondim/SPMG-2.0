package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Models.MedicoEspecialidade;

import java.util.List;

public interface MedicoEspecialidadeRepository {
    public abstract MedicoEspecialidade associateMedicoEspecialidade(AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto);
    public abstract List<MedicoEspecialidade> getAllMedicoEspecialidadesByMedicoId(Long medicoId);

}
