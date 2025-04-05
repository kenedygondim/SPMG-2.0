package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Models.Especialidade;

import java.util.List;

public interface EspecialidadeRepository {
    public abstract Especialidade createEspecialidade(CriarEspecialidadeDto criarEspecialidadeDto);
    public abstract List<Especialidade> getAllEspecialidades();
}


