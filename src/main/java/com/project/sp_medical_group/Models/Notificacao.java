package com.project.sp_medical_group.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE tb_notificacoes (
//        notificacao_id INT IDENTITY(1,1),
//usuario_id INT NOT NULL,
//tipo VARCHAR (50) NOT NULL,
//mensagem VARCHAR (500) NOT NULL,
//is_lida BIT
//CONSTRAINT pk_tb_notificacoes PRIMARY KEY (notificacao_id),
//CONSTRAINT fk_tb_notificacoes_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id)
//        );

@Entity
@Table(name = "tb_notificacoes")
@Getter
@Setter
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificacaoId;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "is_lida")
    private Boolean isLida;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;
}
