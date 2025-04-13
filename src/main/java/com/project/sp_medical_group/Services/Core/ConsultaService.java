package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Enum.SituacaoConsulta;
import com.project.sp_medical_group.Jpa.Repositories.ConsultaJpaRepository;
import com.project.sp_medical_group.Models.Consulta;
import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Repositories.ConsultaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService implements ConsultaRepository {
    private final ObjectMapper objectMapper;
    private final EntityManager entityManager;
    private final ConsultaJpaRepository consultaJpaRepository;

    @Autowired
    public ConsultaService(ObjectMapper objectMapper,
                           ConsultaJpaRepository consultaJpaRepository,
                           EntityManager entityManager)
    {
        this.objectMapper = objectMapper;
        this.consultaJpaRepository = consultaJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Consulta createConsulta(AgendarConsultaDto agendarConsultaDto) {
        //TO-DO implementar validação de horário e data (não permitir agendamento de consulta em data passada)
        //TO-DO implementar validação para não permitir consultas com médicos bloqueados pelo usuário
        //TO-DO implementar validação para não permitir agendamento de consultas em horários já ocupados
        Consulta consultaObj = objectMapper.convertValue(agendarConsultaDto, Consulta.class);
        consultaObj.setDisponibilidade(entityManager.getReference(Disponibilidade.class, agendarConsultaDto.disponibilidadeId()));
        consultaObj.setPaciente(entityManager.getReference(Paciente.class, agendarConsultaDto.pacienteCpf()));
        consultaObj.setEspecialidade(entityManager.getReference(Especialidade.class, agendarConsultaDto.especialidadeId()));
        consultaObj.setSituacao(SituacaoConsulta.AGENDADA.getValor());
        return consultaJpaRepository.save(consultaObj);
    }

    @Override
    public List<Consulta> getAllConsultasByPacienteCpf(String pacienteCpf) {
        return consultaJpaRepository.findAllByPacienteCpf(pacienteCpf);
    }

    @Override
    public String cancelConsulta(Integer consultaId) {
        return "";
    }
}
