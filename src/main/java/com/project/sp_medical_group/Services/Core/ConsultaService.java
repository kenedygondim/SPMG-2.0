package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Enum.SituacaoConsulta;
import com.project.sp_medical_group.Models.Consulta;
import com.project.sp_medical_group.Repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService implements ConsultaRepository {
    private ObjectMapper objectMapper;

    @Autowired
    public ConsultaService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Consulta createConsulta(AgendarConsultaDto agendarConsultaDto) {
        //TO-DO implementar validação de horário e data (não permitir agendamento de consulta em data passada)
        //TO-DO implementar validação para não permitir consultas com médicos bloqueados pelo usuário
        //TO-DO implementar validação para não permitir agendamento de consultas em horários já ocupados
        Consulta consultaObj = objectMapper.convertValue(agendarConsultaDto, Consulta.class);
        consultaObj.setSituacao(SituacaoConsulta.AGENDADA.getValor());
        return consultaObj;
    }

    @Override
    public List<Consulta> getAllConsultasByPacienteCpf(String pacienteCpf) {
        return List.of();
    }

    @Override
    public String cancelConsulta(Integer consultaId) {
        return "";
    }
}
