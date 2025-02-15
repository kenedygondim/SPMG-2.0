package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;

public record CriarRoleDto (
        @NotBlank(message = "O nome da role é obrigatório")
        String roleName
)
{
}
