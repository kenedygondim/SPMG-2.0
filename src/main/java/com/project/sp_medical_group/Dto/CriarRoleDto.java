package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarRoleDto (
        @NotBlank(message = "O nome da role é obrigatório")
        String roleNome
)
{
}
