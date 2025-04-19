package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE TABLE tb_consultas (
//        consulta_id INT IDENTITY(1,1),
//disponibilidade_id INT NOT NULL,
//especialidade_id INT NOT NULL,
//descricao VARCHAR(150) NOT NULL,
//situacao VARCHAR (20) NOT NULL,
//paciente_cpf CHAR(11) NOT NULL,
//is_telemedicina BIT NOT NULL,
//CONSTRAINT pk_tb_consultas PRIMARY KEY (consulta_id),
//CONSTRAINT fk_tb_consultas_tb_disponibilidades FOREIGN KEY (disponibilidade_id) REFERENCES tb_disponibilidades (disponibilidade_id),
//CONSTRAINT fk_tb_consultas_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf),
//CONSTRAINT fk_tb_consultas_tb_especialidades FOREIGN KEY (especialidade_id) REFERENCES tb_especialidades (especialidade_id)
//
//        )

@Entity
@Table(name = "tb_consultas")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consulta_id")
    private Long consultaId;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "is_telemedicina")
    private Boolean isTelemedicina;

    @OneToOne
    @JoinColumn(name = "disponibilidade_id", referencedColumnName = "disponibilidade_id")
    private Disponibilidade disponibilidade;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "especialidade_id", referencedColumnName = "especialidade_id")
    private Especialidade especialidade;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    private Paciente paciente;
}

