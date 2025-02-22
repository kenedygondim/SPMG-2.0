package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CriarPessoaDto(
        @NotBlank(message = "O nome é obrigatório")
        String nomeCompleto,
        @NotBlank(message = "O CPF é obrigatório")
        @Length(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
        String cpf,
        @NotBlank(message = "O número de telefone é obrigatório e deve conter apenas números")
        String numeroTelefone,
        @NotBlank(message = "A data de nascimento é obrigatória")
        @Length(min = 10, max = 10, message = "A data de nascimento deve ter o formato dd/mm/aaaa")
        String dataNascimento,
        @NotBlank(message = "O RG é obrigatório")
        @Length(min = 9, max = 9, message = "O RG deve ter 9 dígitos")
        String rg,
        String sexo
) {
}
