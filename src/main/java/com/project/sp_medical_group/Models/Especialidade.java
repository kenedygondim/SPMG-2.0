package com.project.sp_medical_group.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE tb_especialidades (
//        especialidade_id INT IDENTITY(1,1),
//nome VARCHAR (80) UNIQUE,
//descricao VARCHAR (150),
//CONSTRAINT pk_tb_especialidades PRIMARY KEY (especialidade_id)
//)

@Entity
@Table(name = "tb_especialidades")
@Getter
@Setter
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "especialidade_id")
    private Integer especialidadeId;

    private String nome;

    private String descricao;
}
