package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AssociarMedicoEspecialidadeDto(
    @NotNull(message = "O identificador do médico é obrigatório")
    Long medicoId,
    @NotNull(message = "O ID da especialidade é obrigatório")
    Long especialidadeId,
    @NotNull(message = "O valor do procedimento é obrigatório")
    @Min(value = 0, message = "O valor do procedimento deve ser maior que 0")
    @Max(value = 100000, message = "O valor do procedimento deve ser menor que 100000")
    Double valorProcedimento
) 
{}