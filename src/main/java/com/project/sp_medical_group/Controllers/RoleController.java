package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarRoleDto;
import com.project.sp_medical_group.Models.Role;
import com.project.sp_medical_group.Services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/roles")
@Validated
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/createRole")
    public ResponseEntity<String> createRole(@RequestBody @Valid CriarRoleDto criarRoleDto) {
        roleService.createRole(criarRoleDto);
        return ResponseEntity.ok("Role adicionada com sucesso!");
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
}
