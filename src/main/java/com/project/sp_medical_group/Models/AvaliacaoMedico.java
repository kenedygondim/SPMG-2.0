package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("tb_avaliacoes_medico")
@Getter
@Setter
public class AvaliacaoMedico {
    @Id
    @Column("avaliacao_id")
    private Integer avaliacaoId;

    @Column("medico_cpf")
    private String medicoCpf;

    @Column("paciente_cpf")
    private String pacienteCpf;

    @Column("numero_estrelas")
    private Integer numeroEstrelas;

    @Column("comentario")
    private String comentario;
}
