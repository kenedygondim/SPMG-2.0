package com.project.sp_medical_group.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tb_pessoas")
@Getter
@Setter
public class Pessoa {
    @Id
    private String cpf;

    @Column("nome_completo")
    private String nomeCompleto;

    @Column("dt_nascimento")
    private String dataNascimento;

    @Column("rg")
    private String rg;

    @Column("sexo")
    private String sexo;

    @Column("numero_telefone")
    private String numeroTelefone;

    @Column("endereco_id")
    private Integer enderecoId;
}
