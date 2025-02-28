package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.ReactiveCrudRepository.MedicoReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.MedicoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MedicoService implements MedicoRepository  {
    private final MedicoReactiveCrudRepository medicoReactiveCrudRepository;
    private final PessoaService pessoaService;
    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;

    @Autowired
    public MedicoService(MedicoReactiveCrudRepository medicoReactiveCrudRepository, PessoaService pessoaService, UsuarioService usuarioService, EnderecoService enderecoService) {
        this.medicoReactiveCrudRepository = medicoReactiveCrudRepository;
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
    }

    @Override
    public Flux<Medico> getAllMedicos() {
        return medicoReactiveCrudRepository.findAll();
    }

    @Override
    @Transactional
    public Mono<String> createMedico(CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        try { 
            return enderecoService.createEndereco(criarPessoaUsuarioMedicoEnderecoDto.endereco())
                    .flatMap(enderecoCriado -> pessoaService.createPessoa(criarPessoaUsuarioMedicoEnderecoDto.pessoa(), enderecoCriado.getEnderecoId())
                        .flatMap(pessoaCriada -> usuarioService.createUsuario(criarPessoaUsuarioMedicoEnderecoDto.usuario(), Role.MEDICO)
                            .flatMap(usuarioCriado -> medicoReactiveCrudRepository.insertMedico(criarPessoaUsuarioMedicoEnderecoDto.pessoa().cpf(), usuarioCriado.getUsuarioId(), criarPessoaUsuarioMedicoEnderecoDto.medico().crm())))
                    )
                    .thenReturn("Médico criado com sucesso!");
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma pessoa cadastrada com esse CPF ou RG: " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Erro ao criar médico: " + e.getMessage());
        }
        finally {
            System.out.println("Método createMedico executado!");
        }
    }
}
