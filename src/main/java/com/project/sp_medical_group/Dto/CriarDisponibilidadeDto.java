package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;

public record CriarDisponibilidadeDto(
    @NotBlank(message = "O identificador do médico é obrigatório")
    String medicoCpf,
    @NotBlank(message = "A data da disponibilidade é obrigatória")
    String dataDisp,
    @NotBlank(message = "A hora de início é obrigatória")
    String horaInicio,
    @NotBlank(message = "A hora de fim é obrigatória")
    String horaFim
) 
{   
}
