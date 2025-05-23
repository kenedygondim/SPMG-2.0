package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.DisponibilidadeJpaRepository;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Repositories.DisponibilidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class DisponibilidadeService implements DisponibilidadeRepository {
    private final DisponibilidadeJpaRepository disponibilidadeJpaRepository;
    private final EntityManager entityManager;
    private final ObjectMapper objectMapper;

    @Autowired
    public DisponibilidadeService(DisponibilidadeJpaRepository disponibilidadeJpaRepository,
                                  EntityManager entityManager,
                                  ObjectMapper objectMapper)
    {
        this.disponibilidadeJpaRepository = disponibilidadeJpaRepository;
        this.entityManager = entityManager;
        this.objectMapper = objectMapper;
    }

    @Override
    public Disponibilidade createDisponibilidade(CriarDisponibilidadeDto criarDisponibilidadeDto) {
        try {
            validateDiponibilidade(criarDisponibilidadeDto);
            Disponibilidade disponibilidade = objectMapper.convertValue( criarDisponibilidadeDto, Disponibilidade.class);
            disponibilidade.setMedico(entityManager.getReference(Medico.class, criarDisponibilidadeDto.medicoId()));
            if (criarDisponibilidadeDto.clinicaId() != null)
                disponibilidade.setClinica(entityManager.getReference(Clinica.class, criarDisponibilidadeDto.clinicaId()));
            return disponibilidadeJpaRepository.save(disponibilidade);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        } catch (DateTimeParseException e) {
            throw new BusinessException("Data ou hora inválida: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new BusinessException("Médico não encontrado: " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao criar disponibilidade: " + e.getMessage());
        }
    }

    @Override
    public List<Disponibilidade> getAllDisponibilidadesByMedicoIdAndDataDisp(Long medicoId, String dataDisp) {
        return disponibilidadeJpaRepository.findAllByMedicoMedicoIdAndDataDisp(medicoId, dataDisp);
    }

    @Override
    public Disponibilidade getDisponibilidadeById(Long disponibilidadeId) {
        return disponibilidadeJpaRepository.findById(disponibilidadeId)
                .orElseThrow(() -> new EntityNotFoundException("Disponibilidade não encontrada"));
    }

    private void validateDiponibilidade (CriarDisponibilidadeDto criarDisponibilidadeDto) {
        //TO-DO: Não permitir que disponibilidades no mesmo dia e horário sejam criadas.
        //DONE: Não permitir que disponibilidades sejam criadas sem pelo menos 3 horas de antecedência
        try {
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataDisponibilidade = LocalDate.parse(criarDisponibilidadeDto.dataDisp());
            LocalTime horaInicioDisponibilidade = LocalTime.parse(criarDisponibilidadeDto.horaInicio());
            LocalTime horaFimDisponibilidade = LocalTime.parse(criarDisponibilidadeDto.horaFim());

            if (dataAtual.equals(dataDisponibilidade)) {
                LocalTime horaAtual = LocalTime.now();
                Boolean isHorarioOcupado = disponibilidadeJpaRepository.isHorarioOcupado(criarDisponibilidadeDto.dataDisp(), criarDisponibilidadeDto.horaInicio(), criarDisponibilidadeDto.horaFim(), criarDisponibilidadeDto.medicoId());
                if (isHorarioOcupado)
                    throw new BusinessException("Conflito: Já existe uma disponibilidade cadastrada nesse dia e horário");
                else if (horaAtual.plusHours(3).isAfter(horaInicioDisponibilidade))
                    throw new BusinessException("A consulta deve ser agendada com pelo menos 3 horas de antecedência");
                else if (!(horaInicioDisponibilidade.isAfter(horaAtual) && horaFimDisponibilidade.isAfter(horaInicioDisponibilidade)))
                    throw new BusinessException("Horário da consulta deve ser maior que o horário atual");

            } else if (dataAtual.isAfter(dataDisponibilidade))
                throw new BusinessException("Data da consulta deve ser maior ou igual a data atual");
            if (!horaFimDisponibilidade.isAfter(horaInicioDisponibilidade))
                throw new BusinessException("Horário do fim da consulta deve ser maior que o horário de início");
        } catch (DateTimeParseException e) {
            throw new BusinessException("Data ou hora inválida");
        }
    }
}
