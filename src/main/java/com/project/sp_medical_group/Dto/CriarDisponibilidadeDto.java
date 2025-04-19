package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarDisponibilidadeDto(
    @NotNull(message = "O identificador do médico é obrigatório")
    Long medicoId,
    @NotBlank(message = "A data da disponibilidade é obrigatória")
    String dataDisp,
    Integer clinicaId,
    @NotBlank(message = "A hora de início é obrigatória")
    String horaInicio,
    @NotBlank(message = "A hora de fim é obrigatória")
    String horaFim
) 
{   
}
