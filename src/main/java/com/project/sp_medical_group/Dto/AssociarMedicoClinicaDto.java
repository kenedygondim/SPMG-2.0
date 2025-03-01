package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;

public record AssociarMedicoClinicaDto(
    @NotBlank(message = "O identificador da clínica é obrigatório")
    String clinicaCnpj,
    @NotBlank(message = "O identificador do médico é obrigatório")
    String medicoCpf
) {} 