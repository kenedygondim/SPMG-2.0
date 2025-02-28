package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.ToString;

@Table("tb_medico_convenios")
@Getter
@ToString
public class MedicoConvenio {
    @Id
    @Column("convenio_id")
    private Integer convenioId;

    @Id
    @Column("medico_id")
    private Integer medicoId;
}
