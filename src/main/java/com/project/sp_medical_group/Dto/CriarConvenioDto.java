package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;

public record CriarConvenioDto (
        @NotBlank(message = "O nome do convênio é obrigatório")
        String convenioNome
)
{
}
