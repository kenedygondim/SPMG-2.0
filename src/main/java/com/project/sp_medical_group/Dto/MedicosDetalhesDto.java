package com.project.sp_medical_group.Dto;

import java.math.BigDecimal;

public record MedicosDetalhesDto(
        String nomeCompleto,
        String sexo,
        String especialidadeNome,
        BigDecimal valorProcedimento,
        String convenioNome
) {
}
