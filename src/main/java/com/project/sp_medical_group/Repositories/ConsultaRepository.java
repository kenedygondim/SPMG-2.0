package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Models.Consulta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ConsultaRepository {
    Mono<String> createConsulta(AgendarConsultaDto agendarConsultaDto);
    Flux<Consulta> getAllConsultasByPacienteCpf(String pacienteCpf);
}
