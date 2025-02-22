package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarUsuarioDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.UsuarioJpaRepository;
import com.project.sp_medical_group.Models.Usuario;
import com.project.sp_medical_group.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UsuarioRepository {
    private final UsuarioJpaRepository usuarioJpaRepository;

    @Autowired
    public UsuarioService(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario createUsuario(CriarUsuarioDto criarUsuarioDto, Role role) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Usuario usuario = objectMapper.convertValue(criarUsuarioDto, Usuario.class);
            usuario.setRole(role);
            return usuarioJpaRepository.save(usuario);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Ocorreu um erro de integridade dos dados. (Possível tentativa de quebra de CONSTRAINT) " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioJpaRepository.findAll();
    }
}
