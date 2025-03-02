package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Models.Usuario;
import com.project.sp_medical_group.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("spmg/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("getAllUsuarios")
    public ResponseEntity<Flux<Usuario>> getAllUsuarios() {
        Flux<Usuario> usuarios = usuarioRepository.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
