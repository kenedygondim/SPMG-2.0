package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table("tb_disponibilidades")
@Getter
@ToString
@NoArgsConstructor
public class Disponibilidade {
    public Disponibilidade(String medicoCpf, String dataDisp, String horaInicio, String horaFim) {
        this.medicoCpf = medicoCpf;
        this.dataDisp = dataDisp;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    @Id
    @Column("disponibilidade_id")
    private Integer disponibilidadeId;

    @Column("medico_cpf")
    private String medicoCpf;

    @Column("data_disp")
    private String dataDisp;

    @Column("hora_inicio")
    private String horaInicio;

    @Column("hora_fim")
    private String horaFim;
}
