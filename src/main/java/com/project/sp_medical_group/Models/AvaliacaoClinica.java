package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE tb_avaliacoes_clinica (
//        avaliacao_id INT IDENTITY(1,1),
//clinica_cnpj CHAR(14) NOT NULL,
//paciente_cpf CHAR(11) NOT NULL,
//numero_estrelas INT NOT NULL,
//comentario VARCHAR (255) NOT NULL
//CONSTRAINT pk_tb_avaliacoes_clinica PRIMARY KEY (avaliacao_id),
//CONSTRAINT fk_tb_avaliacoes_clinica_tb_clinicas FOREIGN KEY (clinica_cnpj) REFERENCES tb_clinicas (cnpj),
//CONSTRAINT fk_tb_avaliacoes_clinica_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf)
//        );

@Entity
@Table(name = "tb_avaliacoes_clinica")
@Getter
@Setter
public class AvaliacaoClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long avaliacaoId;

    @Column(name = "numero_estrelas")
    private int numeroEstrelas;

    @Column(name = "comentario")
    private String comentario;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "clinica_cnpj", referencedColumnName = "cnpj")
    private Clinica clinica;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paciente_cpf", referencedColumnName = "cpf")
    private Paciente paciente;
}
