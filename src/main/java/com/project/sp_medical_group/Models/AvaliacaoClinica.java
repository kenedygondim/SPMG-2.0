package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;

@Table("tb_avaliacoes_clinica")
@Getter
public class AvaliacaoClinica {
    // avaliacao_id INT IDENTITY(1,1),
    // clinica_cnpj CHAR(14) NOT NULL,
    // paciente_cpf CHAR(11) NOT NULL,
    // numero_estrelas INT NOT NULL,
    // comentario VARCHAR (255) NOT NULL
    // CONSTRAINT pk_tb_avaliacoes_clinica PRIMARY KEY (avaliacao_id),
    // CONSTRAINT fk_tb_avaliacoes_clinica_tb_clinicas FOREIGN KEY (clinica_cnpj) REFERENCES tb_clinicas (cnpj),
    // CONSTRAINT fk_tb_avaliacoes_clinica_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf)

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
