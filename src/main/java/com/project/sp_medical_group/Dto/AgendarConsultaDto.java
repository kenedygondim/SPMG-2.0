package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendarConsultaDto(
    @NotNull(message = "O identificador do médico é obrigatório")
    Long disponibilidadeId,
    @NotNull(message = "O identificador da especialidade é obrigatório")
    Long especialidadeId,
    @NotBlank(message = "A descrição é obrigatória")
    String descricao,
    @NotNull(message = "O identificador do paciente é obrigatório")
    Long pacienteId,
    Boolean isTelemedicina
) {
} 