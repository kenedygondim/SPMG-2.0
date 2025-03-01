package com.project.sp_medical_group.Models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table("tb_medico_convenios")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicoConvenio {
    @Column("convenio_id")
    private Integer convenioId;

    @Column("medico_cpf")
    private String medicoCpf;
}
