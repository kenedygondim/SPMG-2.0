package com.project.sp_medical_group.Enum;

public enum SituacaoConsulta {
    AGENDADA("AGENDADA"),
    REALIZADA("REALIZADA"),
    CANCELADA_PELO_MEDICO("CANCELADA_PELO_MEDICO"),
    CANCELADA_PELO_PACIENTE("CANCELADA_PELO_PACIENTE"),
    PACIENTE_FALTOU("PACIENTE_FALTOU"),
    MEDICO_FALTOU("MEDICO_FALTOU");

    private final String valor;

    SituacaoConsulta(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static SituacaoConsulta fromValor(String valor) {
        for (SituacaoConsulta situacao : SituacaoConsulta.values()) {
            if (situacao.getValor().equalsIgnoreCase(valor)) {
                return situacao;
            }
        }
        throw new IllegalArgumentException("Situação de consulta inválida: " + valor);
    }

}