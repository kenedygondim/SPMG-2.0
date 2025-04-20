package com.project.sp_medical_group.Models;

import com.project.sp_medical_group.IdClass.BloqueioId;
import com.project.sp_medical_group.IdClass.MedicoConvenioId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE TABLE tb_bloqueios (
//        usuario_id INT,
//        usuario_id_bloqueado INT,
//        CONSTRAINT pk_tb_bloqueios PRIMARY KEY(usuario_id, usuario_id_bloqueado),
//CONSTRAINT fk_tb_bloqueios_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id)
//        );

@Entity
@Table(name = "tb_bloqueios")
@Getter
@Setter
@ToString
@IdClass(BloqueioId.class)
public class Bloqueio {
    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuarioBloqueado;
}
