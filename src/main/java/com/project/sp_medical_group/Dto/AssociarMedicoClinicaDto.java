package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AssociarMedicoClinicaDto(
    @NotNull(message = "O identificador da clínica é obrigatório")
    Long clinicaId,
    @NotNull(message = "O identificador do médico é obrigatório")
    Long medicoId
) {} 