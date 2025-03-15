package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaDto;
import com.project.sp_medical_group.Models.Pessoa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PessoaRepository {
    public abstract Flux<Pessoa> getAllPessoas();
    public abstract Mono<Pessoa> createPessoa(CriarPessoaDto criarPessoaDto, Integer enderecoId);
}
