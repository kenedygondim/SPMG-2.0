package com.project.sp_medical_group.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_roles")
public class Role {
    public Role () {}
    public Role (String roleNome) {
         this.roleNome = roleNome;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_nome")
    private String roleNome;

    public String getRoleNome() {
        return roleNome;
    }

    public void setRoleNome(String roleName) {
        this.roleNome = roleName;
    }

    public int getRoleId() {
        return roleId;
    }
}
