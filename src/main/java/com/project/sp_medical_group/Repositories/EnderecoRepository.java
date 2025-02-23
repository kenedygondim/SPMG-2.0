package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarEnderecoDto;
import com.project.sp_medical_group.Models.Endereco;
import reactor.core.publisher.Mono;

public interface EnderecoRepository {
    Mono<Endereco> createEndereco(CriarEnderecoDto criarEnderecoDto);
}
