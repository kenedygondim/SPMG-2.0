package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonIgnore
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;
}
