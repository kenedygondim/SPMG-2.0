package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarPessoaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.PessoaJpaRepository;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.Models.Pessoa;
import com.project.sp_medical_group.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements PessoaRepository {
    private final PessoaJpaRepository pessoaJpaRepository;

    @Autowired
    public PessoaService(PessoaJpaRepository pessoaJpaRepository) {
        this.pessoaJpaRepository = pessoaJpaRepository;
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return pessoaJpaRepository.findAll();
    }


    @Override
    public Pessoa createPessoa(CriarPessoaDto criarPessoaDto, Endereco endereco) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Pessoa pessoa = objectMapper.convertValue(criarPessoaDto, Pessoa.class);
            pessoa.setEndereco(endereco);
            return pessoaJpaRepository.save(pessoa);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma pessoa cadastrada com esse CPF ou RG: " + e.getMessage());
        }
    }

}
