package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarRoleDto;
import com.project.sp_medical_group.Models.Role;
import com.project.sp_medical_group.Repositories.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/roles")
public class RoleController {
    private RoleRepository roleRepository;
    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping("/adicionarRole")
    public ResponseEntity<String> adicionarRole(@RequestBody @Valid CriarRoleDto criarRoleDto) {
        roleRepository.save(new Role(criarRoleDto.roleName()));
        return ResponseEntity.ok("Role adicionada com sucesso!");
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return ResponseEntity.ok(roles);
    }
}
