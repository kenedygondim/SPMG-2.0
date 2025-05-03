package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_avaliacoes_clinica")
@Getter
@Setter
public class AvaliacaoClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "avaliacao_id")
    private Long avaliacaoId;

    @Column(name = "numero_estrelas")
    private int numeroEstrelas;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "clinica_id", referencedColumnName = "clinica_id")
    private Clinica clinica;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    private Paciente paciente;
}
