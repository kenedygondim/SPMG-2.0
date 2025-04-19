package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Enum.SituacaoConsulta;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.ConsultaJpaRepository;
import com.project.sp_medical_group.Models.Consulta;
import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Repositories.ConsultaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeParseException;
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

        try {
            Consulta consultaObj = new Consulta();
            consultaObj.setDisponibilidade(entityManager.getReference(Disponibilidade.class, agendarConsultaDto.disponibilidadeId()));
            consultaObj.setPaciente(entityManager.getReference(Paciente.class, agendarConsultaDto.pacienteId()));
            consultaObj.setEspecialidade(entityManager.getReference(Especialidade.class, agendarConsultaDto.especialidadeId()));
            consultaObj.setSituacao(SituacaoConsulta.AGENDADA.getValor());
            consultaObj.setDescricao(agendarConsultaDto.descricao());

            if(agendarConsultaDto.isTelemedicina() == null)
                consultaObj.setIsTelemedicina(false);

            return consultaJpaRepository.save(consultaObj);
        } catch (DateTimeParseException e) {
            throw new BusinessException("Data ou hora inválida: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new BusinessException("Médico não encontrado: " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao agendar consulta: " + e.getMessage());
        }
    }

    @Override
    public List<Consulta> getAllConsultasByPacienteId(Long pacienteId) {
        return consultaJpaRepository.findAllByPacientePacienteId(pacienteId);
    }

    @Override
    public String cancelConsulta(Integer consultaId) {
        return "";
    }
}
