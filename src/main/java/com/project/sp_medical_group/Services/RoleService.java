package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarRoleDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.RoleJpaRepository;
import com.project.sp_medical_group.Models.Role;
import com.project.sp_medical_group.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleRepository {
    private final RoleJpaRepository roleJpaRepository;

    @Autowired
    public RoleService(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public Role createRole(CriarRoleDto criarRoleDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Role role = objectMapper.convertValue(criarRoleDto, Role.class);
            return roleJpaRepository.save(role);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe um convênio cadastrado com esse nome: " + e.getMessage());
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return roleJpaRepository.findAll();
    }
}
