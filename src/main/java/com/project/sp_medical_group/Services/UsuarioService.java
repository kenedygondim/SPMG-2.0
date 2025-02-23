package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarUsuarioDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Usuario;
import com.project.sp_medical_group.ReactiveCrudRepository.UsuarioReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService implements UsuarioRepository {
    private final UsuarioReactiveCrudRepository usuarioReactiveCrudRepository;

    @Autowired
    public UsuarioService(UsuarioReactiveCrudRepository usuarioReactiveCrudRepository) {
        this.usuarioReactiveCrudRepository = usuarioReactiveCrudRepository;
    }

    @Override
    public Mono<Usuario> createUsuario(CriarUsuarioDto criarUsuarioDto, Role role) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Usuario usuario = objectMapper.convertValue(criarUsuarioDto, Usuario.class);
            usuario.setRoleName(role);
            return usuarioReactiveCrudRepository.save(usuario);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Ocorreu um erro de integridade dos dados. (Possível tentativa de quebra de CONSTRAINT) " + e.getMessage());
        }
    }

    @Override
    public Flux<Usuario> getAllUsuarios() {
        return usuarioReactiveCrudRepository.findAll();
    }
}
