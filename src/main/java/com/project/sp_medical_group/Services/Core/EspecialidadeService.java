package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Repositories.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService implements EspecialidadeRepository {
    @Override
    public Especialidade createEspecialidade(CriarEspecialidadeDto criarEspecialidadeDto) {
        return null;
    }

    @Override
    public List<Especialidade> getAllEspecialidades() {
        return List.of();
    }
}
