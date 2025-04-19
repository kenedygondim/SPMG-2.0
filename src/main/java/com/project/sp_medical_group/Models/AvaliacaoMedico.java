package com.project.sp_medical_group.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE TABLE tb_avaliacoes_medico (
//        avaliacao_id INT IDENTITY(1,1),
//medico_cpf CHAR(11) NOT NULL,
//paciente_cpf CHAR(11) NOT NULL,
//numero_estrelas INT NOT NULL,
//comentario VARCHAR (255) NOT NULL
//CONSTRAINT pk_tb_avaliacoes_medico PRIMARY KEY (avaliacao_id),
//CONSTRAINT fk_tb_avaliacoes_medico_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
//CONSTRAINT fk_tb_avaliacoes_medico_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf)
//        );

@Entity

@Table(name = "tb_avaliacoes_medico")
@Getter
@Setter
@ToString
public class AvaliacaoMedico {
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
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    private Medico medico;

    //    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    private Paciente paciente;
}
