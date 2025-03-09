package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Models.AvaliacaoClinica;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AvaliacaoClinicaRepository {
    Mono<AvaliacaoClinica> createAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto);
    Flux<AvaliacaoClinica> getAllAvaliacoesClinicaByClinicaCnpj(String clinicaCnpj);
    Flux<AvaliacaoClinica> getAllAvaliacoesClinicaByPacienteCpf(String pacienteCpf);
}
