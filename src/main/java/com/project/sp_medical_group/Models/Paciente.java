package com.project.sp_medical_group.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pacientes")
@Getter
@Setter
@NoArgsConstructor
public class Paciente {
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
}
