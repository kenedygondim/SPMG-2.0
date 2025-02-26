package com.project.sp_medical_group.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tb_clinicas")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Clinica {

    public Clinica (String cnpj, String nomeFantasia, String razaoSocial) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    @Id
    @Column("cnpj")
    private String cnpj;

    @Column("nome_fantasia")
    private String nomeFantasia;

    @Column("razao_social")
    private String razaoSocial;

    @Column("endereco_id")
    private Integer enderecoId;
}
