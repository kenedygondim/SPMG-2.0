package com.project.sp_medical_group.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_convenios")
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "convenio_id")
    private int convenioId;

    @Column(name = "convenio_nome")
    private String convenioNome;

    public int getConvenioId() {
        return convenioId;
    }

    public String getConvenioNome() {
        return convenioNome;
    }

    public void setConvenioNome(String convenioNome) {
        this.convenioNome = convenioNome;
    }
}
