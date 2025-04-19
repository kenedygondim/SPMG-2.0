package com.project.sp_medical_group.Models;


import com.project.sp_medical_group.IdClass.MedicoClinicaId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE TABLE tb_medico_clinicas (
//        medico_id INT NOT NULL,
//        clinica_id INT NOT NULL ,
//        CONSTRAINT pk_tb_medico_clinicas PRIMARY KEY (medico_id, clinica_id),
//CONSTRAINT fk_tb_medico_clinicas_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
//CONSTRAINT fk_tb_medico_clinicas_tb_clinicas FOREIGN KEY (clinica_id) REFERENCES tb_clinicas (clinica_id)
//        );


@Entity
@Table(name = "tb_medico_clinicas")
@Getter
@Setter
@ToString
@IdClass(MedicoClinicaId.class)
public class MedicoClinica {
    @Id
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    private Medico medico;

    @Id
    @ManyToOne
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    private Clinica clinica;
}
