package com.project.sp_medical_group.Models;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.NoArgsConstructor;
import lombok.Getter;

@Table(name = "tb_especialidades")
@Getter
@NoArgsConstructor
@ToString
public class Especialidade {
    public Especialidade (String especialidadeNome, String especialidadeDescricao) {
        this.especialidadeNome = especialidadeNome;
        this.especialidadeDescricao = especialidadeDescricao;
    }

    @Id
    @Column("especialidade_id")
    private Integer especialidadeId;

    @Column("nome")
    private String especialidadeNome;

    @Column("descricao")
    private String especialidadeDescricao;
}
