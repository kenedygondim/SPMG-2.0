package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table("tb_saude_observacoes")
@Getter
@ToString
public class SaudeObservacoes {
    @Id
    @Column("saude_observacoes_id")
    private Integer saudeObservacoesId;

    @Column("paciente_cpf")
    @Setter
    private String pacienteCpf;

    @Column("alergias")
    @Setter
    private String alergias;

    @Column("doencas")
    @Setter
    private String doencas;
}
