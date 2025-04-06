package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.sp_medical_group.Enum.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_usuarios")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    public Usuario (String email, String senha, Role roleName) {
        this.email = email;
        this.senha = senha;
        this.roleName = roleName;
    }

    public Usuario (String email, String senha, String fotoPerfil, Role roleName) {
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    @Setter(AccessLevel.NONE)
    private Integer usuarioId;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "foto_perfil_url")
    private String fotoPerfil;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Role roleName;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Paciente paciente;
}
