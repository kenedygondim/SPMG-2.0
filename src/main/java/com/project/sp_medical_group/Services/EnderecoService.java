package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarEnderecoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.EnderecoJpaRepository;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.Repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements EnderecoRepository {
    private final EnderecoJpaRepository enderecoJpaRepository;

    @Autowired
    public EnderecoService(EnderecoJpaRepository enderecoJpaRepository) {
        this.enderecoJpaRepository = enderecoJpaRepository;
    }

    @Override
    public Endereco createEndereco(CriarEnderecoDto criarEnderecoDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Endereco endereco = objectMapper.convertValue(criarEnderecoDto, Endereco.class);
            return enderecoJpaRepository.save(endereco);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
    }
}
