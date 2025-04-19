package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Medico (Pessoa pessoa, String crm, Usuario usuario) {
        this.pessoa = pessoa;
        this.crm = crm;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long medicoId;

    @Column(name = "crm")
    private String crm;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private Pessoa pessoa;
}
