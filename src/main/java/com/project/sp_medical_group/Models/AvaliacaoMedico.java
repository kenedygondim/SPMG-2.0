package com.project.sp_medical_group.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_avaliacoes_medico")
@Getter
@Setter
@ToString
public class AvaliacaoMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long avaliacaoId;

    @Column(name = "numero_estrelas")
    private int numeroEstrelas;

    @Column(name = "comentario")
    private String comentario;

    //    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
    private Medico medico;

    //    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    private Paciente paciente;
}
