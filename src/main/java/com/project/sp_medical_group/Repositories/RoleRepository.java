package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarRoleDto;
import com.project.sp_medical_group.Models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleRepository {
    Role createRole(CriarRoleDto criarRoleDto);
    List<Role> getAllRoles();
}
