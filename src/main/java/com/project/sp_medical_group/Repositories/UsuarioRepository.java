package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarUsuarioDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario createUsuario(CriarUsuarioDto criarUsuarioDto, Role role);
    List<Usuario> getAllUsuarios();
}
