package com.project.sp_medical_group.Services;

import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.ReactiveCrudRepository.DisponibilidadeReactiveCrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Repositories.DisponibilidadeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DisponibilidadeService implements DisponibilidadeRepository {
    private final DisponibilidadeReactiveCrudRepository disponibilidadeReactiveCrudRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public DisponibilidadeService(DisponibilidadeReactiveCrudRepository disponibilidadeReactiveCrudRepository, ObjectMapper objectMapper) {
        this.disponibilidadeReactiveCrudRepository = disponibilidadeReactiveCrudRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Disponibilidade> createDisponibilidade(CriarDisponibilidadeDto criarDisponibilidadeDto) {
        this.validateDiponibilidade(criarDisponibilidadeDto);
        return Mono.fromCallable(() -> objectMapper.convertValue(criarDisponibilidadeDto, Disponibilidade.class))
            .flatMap(disponibilidadeReactiveCrudRepository::save)
            .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar disponibilidade"));
    }

    @Override
    public Flux<Disponibilidade> getAllDisponibilidadesByMedicoCpf(String medicoCpf) {
        return disponibilidadeReactiveCrudRepository.findAllByMedicoCpf(medicoCpf);
    }

    private void validateDiponibilidade (CriarDisponibilidadeDto criarDisponibilidadeDto) {
        try {
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataDisponibilidade = LocalDate.parse(criarDisponibilidadeDto.dataDisp());
            LocalTime horaInicioDisponibilidade = LocalTime.parse(criarDisponibilidadeDto.horaInicio());
            LocalTime horaFimDisponibilidade = LocalTime.parse(criarDisponibilidadeDto.horaFim());
            if (dataAtual.equals(dataDisponibilidade)) {
                LocalTime horaAtual = LocalTime.now();
                if (!(horaInicioDisponibilidade.isAfter(horaAtual) && horaFimDisponibilidade.isAfter(horaInicioDisponibilidade))) 
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
