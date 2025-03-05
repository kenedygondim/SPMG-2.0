package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendarConsultaDto(
    @NotNull(message = "O identificador do médico é obrigatório")
    String disponibilidadeId,
    @NotNull(message = "O identificador da especialidade é obrigatório")
    String especialidadeId,
    @NotBlank(message = "A descrição é obrigatória")
    String descricao,
    @NotBlank(message = "O identificador do paciente é obrigatório")
    String pacienteCpf,
    boolean isTelemedicina
) {
} 