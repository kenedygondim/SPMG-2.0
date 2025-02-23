package com.project.sp_medical_group.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tb_clinicas")
@Getter
@Setter
public class Clinica {
    @Id
    @Column("cnpj")
    private String cnpj;

    @Column("nome_fantasia")
    private String nomeFantasia;

    @Column("razao_social")
    private String razaoSocial;

    @Column("endereco_id")
    private Integer enderecoId;

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

}
