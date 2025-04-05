package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_enderecos")
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    public Endereco(String cep, String uf, String municipio, String bairro, String logradouro, String numero, String complemento) {
        this.cep = cep;
        this.uf = uf;
        this.municipio = municipio;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    @Setter(AccessLevel.NONE)
    private Integer enderecoId;

    @Column(name = "cep")
    private String cep;

    @Column(name = "uf")
    private String uf;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Clinica clinica;

    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Pessoa pessoa;
}
