package com.project.sp_medical_group.Models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table("tb_medico_especialidades")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoEspecialidade {
    @Column("medico_cpf")
    private String medicoCpf;

    @Column("especialidade_id")
    private Integer especialidadeId;

    @Column("valor_procedimento")
    private Double valorProcedimento;
}
