package com.project.sp_medical_group.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//CREATE TABLE tb_medicos (
//        cpf CHAR(11),
//crm CHAR(8) NOT NULL UNIQUE,
//usuario_id INT NOT NULL,
//CONSTRAINT pk_tb_medicos PRIMARY KEY (cpf),
//CONSTRAINT fk_tb_medicos_tb_pessoas FOREIGN KEY (cpf) REFERENCES tb_pessoas (cpf),
//CONSTRAINT fk_tb_medicos_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id),
//        );

@Entity
@Table(name = "tb_medicos")
@NoArgsConstructor
@Getter
@Setter
public class Medico {

    public Medico (String cpf, String crm, Usuario usuario) {
        this.cpf = cpf;
        this.crm = crm;
        this.usuario = usuario;
    }

    @Id
    private String cpf;

    private String crm;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private Pessoa pessoa;
}
