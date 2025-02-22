package com.project.sp_medical_group.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
    @Id
    private String cpf;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "dt_nascimento")
    private String dataNascimento;

    @Column(name = "rg")
    private String rg;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "numero_telefone")
    private String numeroTelefone;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
