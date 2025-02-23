package com.project.sp_medical_group.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.sp_medical_group.Enum.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "tb_usuarios")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    public Usuario (String email, String senha, Role roleName) {
        this.email = email;
        this.senha = senha;
        this.roleName = roleName.getValor();
    }

    @Id
    @Getter
    @Column("usuario_id")
    private Integer usuarioId;

    @Column("email")
    private String email;

    @Column("senha")
    private String senha;

    @Column("foto_perfil_url")
    private String fotoPerfilUrl;

    @Column("role_name")
    private String roleName;

    public Role getRoleName() {
        return Role.fromValor(roleName);
    }
    public void setRoleName(Role roleName) {
        this.roleName = roleName.getValor();
    }
}
