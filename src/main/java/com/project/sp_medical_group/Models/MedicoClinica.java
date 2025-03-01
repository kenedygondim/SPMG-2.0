package com.project.sp_medical_group.Models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table("tb_medico_clinicas")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicoClinica {
    @Column("clinica_cnpj")
    private String clinicaCnpj;

    @Column("medico_cpf")
    private String medicoCpf;
}