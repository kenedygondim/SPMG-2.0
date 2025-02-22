package com.project.sp_medical_group.Dto;

import jakarta.validation.Valid;

public record CriarPessoaUsuarioEnderecoDto(
       @Valid CriarPessoaDto pessoa,
       @Valid CriarUsuarioDto usuario,
       @Valid CriarEnderecoDto endereco
)
{
}