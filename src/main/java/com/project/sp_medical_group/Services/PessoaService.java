package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarPessoaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.ReactiveCrudRepository.PessoaReactiveCrudRepository;
import com.project.sp_medical_group.Models.Pessoa;
import com.project.sp_medical_group.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PessoaService implements PessoaRepository {
    private final PessoaReactiveCrudRepository pessoaReactiveCrudRepository;

    @Autowired
    public PessoaService(PessoaReactiveCrudRepository pessoaReactiveCrudRepository) {
        this.pessoaReactiveCrudRepository = pessoaReactiveCrudRepository;
    }

    @Override
    public Flux<Pessoa> getAllPessoas() {
        return pessoaReactiveCrudRepository.findAll();
    }

    @Override
    public Mono<Pessoa> createPessoa(CriarPessoaDto criarPessoaDto, Integer enderecoId) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Pessoa pessoa = objectMapper.convertValue(criarPessoaDto, Pessoa.class);
            pessoa.setEnderecoId(enderecoId);
            return pessoaReactiveCrudRepository.save(pessoa);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma pessoa cadastrada com esse CPF ou RG: " + e.getMessage());
        }
    }

}
