package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AssociarMedicoConvenioDto(
    @NotNull(message = "O identificador do convênio é obrigatório")
    Long convenioId,
    @NotNull(message = "O identificador do médico é obrigatório")
    Long medicoId
) 
{}
