package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "tb_medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medico {
    @Id
    private String cpf;

    @Column("usuario_id")
    private Integer usuario_id;

    @Column("crm")
    private String crm;
}
