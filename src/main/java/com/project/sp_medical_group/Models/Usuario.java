package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.sp_medical_group.Enum.Role;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_usuarios")
public class Usuario {
    public Usuario () { }

    public Usuario (String email, String senha, Role roleName) {
        this.email = email;
        this.senha = senha;
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "foto_perfil_url")
    private String fotoPerfil;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Role roleName;

//    @OneToOne(mappedBy = "usuario")
//    @JsonIgnore
//    private Medico medico;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Paciente paciente;

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Role getRole() {
        return roleName;
    }

    public void setRole(Role roleName) {
        this.roleName = roleName;
    }

}
