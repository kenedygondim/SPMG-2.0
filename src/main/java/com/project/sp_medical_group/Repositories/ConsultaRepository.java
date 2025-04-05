package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Models.Consulta;

import java.util.List;

public interface ConsultaRepository {
    public abstract Consulta createConsulta(AgendarConsultaDto agendarConsultaDto);
    public abstract List<Consulta> getAllConsultasByPacienteCpf(String pacienteCpf);
    public abstract String cancelConsulta(Integer consultaId);
}
