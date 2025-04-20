package com.project.sp_medical_group.Models;

import jakarta.persistence.*;

//CREATE TABLE tb_saude_observacoes (
//        saude_observacoes_id INT IDENTITY (1,1),
//paciente_id INT NOT NULL,
//alergias VARCHAR (150),
//doencas VARCHAR (150)
//CONSTRAINT pk_saude_observacoes PRIMARY KEY (saude_observacoes_id),
//CONSTRAINT fk_saude_observacoes_tb_pacientes FOREIGN KEY (paciente_id) REFERENCES tb_pacientes (paciente_id)
//        );

@Entity
@Table(name = "tb_saude_observacoes")
public class SaudeObservacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saude_observacoes_id")
    private Long saudeObservacoesId;

    @Column(name = "alergias")
    private String alergias;

    @Column(name = "doencas")
    private String doencas;

    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    private Paciente paciente;
}
