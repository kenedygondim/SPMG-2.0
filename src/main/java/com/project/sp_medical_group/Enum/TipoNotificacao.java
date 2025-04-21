package com.project.sp_medical_group.Enum;

public enum TipoNotificacao {
    CONSULTA_AGENDADA("Consulta Agendada"),
    CONSULTA_REALIZADA("Consulta Realizada"),
    CONSULTA_CANCELADA_PACIENTE("Consulta Cancelada pelo paciente"),
    CONSULTA_CANCELADA_MEDICO("Consulta Cancelada pelo médico"),
    ADICIONADO_A_CLINICA("Adicionado a clínica"),
    REMOVIDO_DA_CLINICA("Removido da clínica");

    private final String valor;

    TipoNotificacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoNotificacao fromValor(String valor) {
        for (TipoNotificacao tipo : TipoNotificacao.values()) {
            if (tipo.getValor().equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de notificação inválida: " + valor);
    }
}
