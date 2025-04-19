package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.MedicoJpaRepository;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Models.Pessoa;
import com.project.sp_medical_group.Models.Usuario;
import com.project.sp_medical_group.Repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService implements MedicoRepository {
    private final EnderecoService enderecoService;
    private final PessoaService pessoaService;
    private final UsuarioService usuarioService;
    private final MedicoJpaRepository medicoJpaRepository;

    @Autowired
    public MedicoService(EnderecoService enderecoService, PessoaService pessoaService, UsuarioService usuarioService, MedicoJpaRepository medicoJpaRepository) {
        this.enderecoService = enderecoService;
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.medicoJpaRepository = medicoJpaRepository;
    }

    @Override
    public List<Medico> getAllMedicos() {
        return medicoJpaRepository.findAll();
    }

    @Override
    @Transactional
    public Medico createMedico(CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        Medico medico = new Medico ();
        try {
            Endereco endereco = enderecoService.createEndereco(criarPessoaUsuarioMedicoEnderecoDto.endereco());
            Pessoa pessoa = pessoaService.createPessoa(criarPessoaUsuarioMedicoEnderecoDto.pessoa(), endereco);
            Usuario usuario = usuarioService.createUsuario(criarPessoaUsuarioMedicoEnderecoDto.usuario(), Role.MEDICO);
            medico.setPessoa(pessoa);
            medico.setCrm(criarPessoaUsuarioMedicoEnderecoDto.medico().crm());
            medico.setUsuario(usuario);
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Ocorreu um erro de integridade dos dados. (Possível tentativa de quebra de CONSTRAINT) " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Ocorreu um erro inesperado: " + e.getMessage());
        }

        return medicoJpaRepository.save(medico);
    }
}
