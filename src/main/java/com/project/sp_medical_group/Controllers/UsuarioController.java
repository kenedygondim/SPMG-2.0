package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Models.Usuario;
import com.project.sp_medical_group.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("spmg/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("getAllUsuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("updateFotoPerfil")
    public ResponseEntity<String> updateFotoPerfil(@RequestParam Long usuarioId, @RequestBody MultipartFile fotoPerfil) {
        return ResponseEntity.ok(usuarioRepository.updateFotoPerfil(usuarioId, fotoPerfil).toString());
    }
}
