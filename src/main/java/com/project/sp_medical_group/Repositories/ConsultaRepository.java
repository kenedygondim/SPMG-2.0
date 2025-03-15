package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Models.Consulta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ConsultaRepository {
    public abstract Mono<String> createConsulta(AgendarConsultaDto agendarConsultaDto);
    public abstract Flux<Consulta> getAllConsultasByPacienteCpf(String pacienteCpf);
    public abstract Mono<String> cancelConsulta(Integer consultaId);
}
