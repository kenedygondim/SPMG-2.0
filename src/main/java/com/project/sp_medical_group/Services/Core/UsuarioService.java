package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarUsuarioDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.UsuarioJpaRepository;
import com.project.sp_medical_group.Models.Usuario;
import com.project.sp_medical_group.Repositories.UsuarioRepository;
import com.project.sp_medical_group.Services.Oracle.OCIObjectStorageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class UsuarioService implements UsuarioRepository {
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final ObjectMapper objectMapper;
    private final OCIObjectStorageService ociObjectStorageService;

    @Autowired
    public UsuarioService(UsuarioJpaRepository usuarioJpaRepository, ObjectMapper objectMapper, OCIObjectStorageService ociObjectStorageService) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.objectMapper = objectMapper;
        this.ociObjectStorageService = ociObjectStorageService;
    }

    @Override
    public Usuario createUsuario(CriarUsuarioDto criarUsuarioDto, Role role) {
        try {
            Usuario usuario = objectMapper.convertValue(criarUsuarioDto, Usuario.class);
            usuario.setRoleName(role);
            return usuarioJpaRepository.save(usuario);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Ocorreu um erro de integridade dos dados. (Possível tentativa de quebra de CONSTRAINT) " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioJpaRepository.findAll();
    }

    @Override
    @Transactional
    public Usuario updateFotoPerfil(Long usuarioId, MultipartFile fotoPerfil) {

        if (fotoPerfil.isEmpty())
            throw new BusinessException("Arquivo vazio! Envie um arquivo válido.");
        Usuario usuario = usuarioJpaRepository.findById(usuarioId).orElseThrow(() -> new BusinessException("Usuário não encontrado com o ID: " + usuarioId));

        String fileName = "SP-MEDICAL-GROUP-USER-PROFILE-PICTURE-" + usuarioId + ".jpg";
        String urlAcesso = "https://gr0xrblz5vhz.objectstorage.sa-saopaulo-1.oci.customer-oci.com/n/gr0xrblz5vhz/b/sp-medical-group/o/profile-pictures%2F" + fileName;
        try {
            ociObjectStorageService.uploadFile(fotoPerfil, fileName);
            usuario.setFotoPerfil(urlAcesso);
            return usuarioJpaRepository.save(usuario);
        }
        catch (FileNotFoundException e) {
            throw new BusinessException("Arquivo não encontrado: " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Erro ao fazer upload do arquivo: " + e.getMessage());
        }

    }
}




