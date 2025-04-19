package com.project.sp_medical_group.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_clinicas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Clinica {
    public Clinica(String cnpj, String nomeFantasia, String razaoSocial) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinica_id")
    private Long clinicaId;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "razao_social")
    private String razaoSocial;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;
}
