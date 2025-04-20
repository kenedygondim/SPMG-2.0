package com.project.sp_medical_group.Models;

import com.project.sp_medical_group.IdClass.MedicoClinicaId;
import com.project.sp_medical_group.IdClass.MedicoConvenioId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE TABLE tb_medico_convenios (
//        convenio_id INT NOT NULL,
//        medico_id INT NOT NULL,
//        CONSTRAINT pk_tb_medico_convenios PRIMARY KEY (convenio_id, medico_id),
//CONSTRAINT fk_tb_medico_convenios_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
//CONSTRAINT fk_tb_medico_convenios_tb_convenios FOREIGN KEY (convenio_id) REFERENCES tb_convenios (convenio_id)
//        );

@Entity
@Table(name = "tb_medico_convenios")
@Getter
@Setter
@ToString
@IdClass(MedicoConvenioId.class)
public class MedicoConvenio {
    @Id
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    private Medico medico;

    @Id
    @ManyToOne
    @JoinColumn(name = "convenio_id", referencedColumnName = "convenio_id")
    private Convenio convenio;
}
