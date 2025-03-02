package com.project.sp_medical_group.Dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record CriarEspecialidadeDto(
    @NotBlank(message = "O nome da especialidade é obrigatório")
    String especialidadeNome,
    @NotBlank(message = "A descrição da especialidade é obrigatória")
    @Length(min = 10, max = 150, message = "A descrição deve ter no mínimo 10 caracteres e no máximo 150")
    String especialidadeDescricao
) 
{}
