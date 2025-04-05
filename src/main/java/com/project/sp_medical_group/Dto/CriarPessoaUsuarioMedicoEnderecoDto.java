package com.project.sp_medical_group.Dto;

import jakarta.validation.Valid;

public record CriarPessoaUsuarioMedicoEnderecoDto(
    @Valid CriarPessoaDto pessoa,
    @Valid CriarUsuarioDto usuario,
    @Valid CriarMedicoDto medico,
    @Valid CriarEnderecoDto endereco
) 
{}
