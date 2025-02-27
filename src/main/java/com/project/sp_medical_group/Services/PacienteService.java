package com.project.sp_medical_group.Services;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.ReactiveCrudRepository.PacienteReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PacienteService implements PacienteRepository {
    private final PacienteReactiveCrudRepository pacienteReactiveCrudRepository;
    private final PessoaService pessoaService;
    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;

    @Autowired
    public PacienteService(PacienteReactiveCrudRepository pacienteReactiveCrudRepository, PessoaService pessoaService, UsuarioService usuarioService, EnderecoService enderecoService) {
        this.pacienteReactiveCrudRepository = pacienteReactiveCrudRepository;
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
    }

    @Override
    public Flux<Paciente> getAllPacientes() {
        return pacienteReactiveCrudRepository.findAll();
    }

    @Transactional
    @Override
    public Mono<String> createPaciente(CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto) {
        try { 
            return enderecoService.createEndereco(criarPessoaUsuarioEnderecoDto.endereco())
                    .flatMap(enderecoCriado -> pessoaService.createPessoa(criarPessoaUsuarioEnderecoDto.pessoa(), enderecoCriado.getEnderecoId())
                        .flatMap(pessoaCriada -> usuarioService.createUsuario(criarPessoaUsuarioEnderecoDto.usuario(), Role.PACIENTE)
                            .flatMap(usuarioCriado -> pacienteReactiveCrudRepository.insertPaciente(criarPessoaUsuarioEnderecoDto.pessoa().cpf(), usuarioCriado.getUsuarioId())))
                    )
                    .thenReturn("Paciente criado com sucesso!");
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma pessoa cadastrada com esse CPF ou RG: " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Erro ao criar paciente: " + e.getMessage());
        }
    }
}
