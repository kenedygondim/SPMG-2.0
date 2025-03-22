package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;

@Table("tb_avaliacoes_clinica")
@Getter
public class AvaliacaoClinica {
    @Id
    @Column("avaliacao_id")
    private Integer avaliacaoId;

    @Column("clinica_cnpj")
    private String clinicaCnpj;

    @Column("paciente_cpf")
    private String pacienteCpf;

    @Column("numero_estrelas")
    private Integer numeroEstrelas;

    @Column("comentario")
    private String comentario;
}
