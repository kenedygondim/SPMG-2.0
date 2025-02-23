package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Models.Paciente;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PacienteRepository {
    Flux<Paciente> getAllPacientes();
    @Transactional
    Mono<Paciente> createPaciente(CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto);
}
