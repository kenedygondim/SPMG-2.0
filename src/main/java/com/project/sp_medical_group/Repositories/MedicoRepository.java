package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MedicoRepository {
    Flux<Medico> getAllMedicos();
    Mono<String> createMedico(CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto);
}
