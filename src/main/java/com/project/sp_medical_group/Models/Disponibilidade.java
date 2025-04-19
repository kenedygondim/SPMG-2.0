package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//disponibilidade_id INT IDENTITY(1,1),
//medico_cpf CHAR(11) NOT NULL,
//data_disp CHAR(10) NOT NULL,
//hora_inicio CHAR(5) NOT NULL,
//hora_fim CHAR(5) NOT NULL,
//CONSTRAINT pk_tb_disponibilidades PRIMARY KEY (disponibilidade_id),
//CONSTRAINT fk_tb_disponibilidades_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf)

@Entity
@Table(name = "tb_disponibilidades")
@Getter
@Setter
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disponibilidade_id")
    private Long disponibilidadeId;

    @Column(name = "data_disp")
    private String dataDisp;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fim")
    private String horaFim;

    @ManyToOne
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    private Clinica clinica;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    private Medico medico;
}
