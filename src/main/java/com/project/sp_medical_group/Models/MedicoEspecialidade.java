package com.project.sp_medical_group.Models;


import com.project.sp_medical_group.IdClass.MedicoEspecialidadeId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE TABLE tb_medico_especialidades (
//        medico_cpf CHAR(11),
//especialidade_id INT,
//valor_procedimento DECIMAL(6,2),
//CONSTRAINT pk_tb_medico_especialidades PRIMARY KEY (medico_cpf, especialidade_id),
//CONSTRAINT fk_tb_medico_especialidades_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
//CONSTRAINT fk_tb_medico_especialidades_tb_especialidades FOREIGN KEY (especialidade_id) REFERENCES tb_especialidades (especialidade_id)
//        )



@Entity
@Table(name = "tb_medico_especialidades")
@Getter
@Setter
@IdClass(MedicoEspecialidadeId.class)
@ToString
public class MedicoEspecialidade {
    @Id
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    private Medico medico;

    @Id
    @ManyToOne
    @JoinColumn(name = "especialidade_id", referencedColumnName = "especialidade_id")
    private Especialidade especialidade;

    private Double valorProcedimento;
}
