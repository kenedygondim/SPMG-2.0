package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarUsuarioDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Models.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRepository {
    Mono<Usuario> createUsuario(CriarUsuarioDto criarUsuarioDto, Role role);
    Flux<Usuario> getAllUsuarios();
}
