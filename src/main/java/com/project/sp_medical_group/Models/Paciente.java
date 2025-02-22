package com.project.sp_medical_group.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pacientes")
public class Paciente {
    public Paciente() {}

    public Paciente (String cpf, Usuario usuario) {
        this.cpf = cpf;
        this.usuario = usuario;
    }

    @Id
    private String cpf;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
