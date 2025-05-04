package com.project.sp_medical_group.Dto;

import org.springframework.context.annotation.Description;

import java.math.BigDecimal;

public record MedicosDetalhesDto(
        @Description("Importante para a I.A identificar quando está tratando dados do mesmo médico.")
        Integer medicoId,
        String nomeCompleto,
        String sexo,
        String especialidadeNome,
        BigDecimal valorProcedimento,
        String convenioNome,
        @Description("Média de todas as avaliações recebidas pelos pacientes com consultas já realizadas.")
        Integer avaliacao
) {
}
