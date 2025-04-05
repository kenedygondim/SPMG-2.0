package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.Repositories.DisponibilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadeService implements DisponibilidadeRepository {

    @Override
    public Disponibilidade createDisponibilidade(CriarDisponibilidadeDto criarDisponibilidadeDto) {
        return null;
    }

    @Override
    public List<Disponibilidade> getAllDisponibilidadesByMedicoCpf(String medicoCpf) {
        return List.of();
    }
}
