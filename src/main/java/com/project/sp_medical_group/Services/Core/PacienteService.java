package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.PacienteJpaRepository;
import com.project.sp_medical_group.Models.*;
import com.project.sp_medical_group.Repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements PacienteRepository {
    private final PacienteJpaRepository pacienteJpaRepository;
    private final PessoaService pessoaService;
    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;

    @Autowired
    public PacienteService(PacienteJpaRepository pacienteJpaRepository, PessoaService pessoaService, UsuarioService usuarioService, EnderecoService enderecoService) {
        this.pacienteJpaRepository = pacienteJpaRepository;
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteJpaRepository.findAll();
    }

    @Override
    @Transactional
    public Paciente createPaciente(CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Endereco enderecoCriado = enderecoService.createEndereco(criarPessoaUsuarioEnderecoDto.endereco());
            Pessoa pessoaCriada = pessoaService.createPessoa(criarPessoaUsuarioEnderecoDto.pessoa(), enderecoCriado);
            Usuario usuarioCriado = usuarioService.createUsuario(criarPessoaUsuarioEnderecoDto.usuario(), Role.PACIENTE);
            Paciente paciente = new Paciente(pessoaCriada.getCpf(), usuarioCriado);

            return pacienteJpaRepository.save(paciente);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma pessoa cadastrada com esse CPF ou RG: " + e.getMessage());
        }
    }
}
