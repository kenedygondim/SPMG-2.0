package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Models.AvaliacaoClinica;

import java.util.List;


public interface AvaliacaoClinicaRepository {
    public abstract AvaliacaoClinica createAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto);
    public abstract List<AvaliacaoClinica> getAllAvaliacoesClinicaByClinicaId(Long clinicaId);
    public abstract List<AvaliacaoClinica> getAllAvaliacoesClinicaByPacienteId(Long pacienteId);
    public abstract AvaliacaoClinica addAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto);
}
