package com.project.sp_medical_group.Enum;

public enum Role {
    PACIENTE("PACIENTE"),
    MEDICO("MEDICO"),
    ADMIN("ADMIN");

    private final String valor;

    Role(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Role fromValor(String valor) {
        for (Role role : Role.values()) {
            if (role.getValor().equalsIgnoreCase(valor)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Role inválida: " + valor);
    }
}
