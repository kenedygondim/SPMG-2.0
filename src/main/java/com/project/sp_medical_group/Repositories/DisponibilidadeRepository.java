package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Models.Disponibilidade;

import java.util.List;

public interface DisponibilidadeRepository {
    public abstract Disponibilidade createDisponibilidade(CriarDisponibilidadeDto criarDisponibilidadeDto);
    public abstract List<Disponibilidade> getAllDisponibilidadesByMedicoIdAndDataDisp(Long medicoId, String dataDisp);
}
