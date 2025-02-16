package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRoleNome(String roleName);
}
