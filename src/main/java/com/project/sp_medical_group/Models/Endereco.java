package com.project.sp_medical_group.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tb_enderecos")
@Getter
public class Endereco {
    @Id
    @Column("endereco_id")
    private Integer enderecoId;

    @Column("cep")
    @Setter
    private String cep;

    @Column( "uf")
    @Setter
    private String uf;

    @Column("municipio")
    @Setter
    private String municipio;

    @Column("bairro")
    @Setter
    private String bairro;

    @Column("logradouro")
    @Setter
    private String logradouro;

    @Column("numero")
    @Setter
    private String numero;

    @Column("complemento")
    @Setter
    private String complemento;
}
