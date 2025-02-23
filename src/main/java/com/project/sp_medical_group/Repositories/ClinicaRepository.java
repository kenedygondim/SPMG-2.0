package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Models.Clinica;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClinicaRepository {
    Flux<Clinica> getAllClinicas();
    Mono<Clinica> createClinica(CriarClinicaEnderecoDto criarClinicaEnderecoDto);
}
