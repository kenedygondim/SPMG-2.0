package com.project.sp_medical_group.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class Usuario {
    public Usuario() { }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    @Id
    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
}
