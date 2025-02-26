package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarEnderecoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.ReactiveCrudRepository.EnderecoReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EnderecoService implements EnderecoRepository {
    private final EnderecoReactiveCrudRepository enderecoReactiveCrudRepository;

    @Autowired
    public EnderecoService(EnderecoReactiveCrudRepository enderecoReactiveCrudRepository) {
        this.enderecoReactiveCrudRepository = enderecoReactiveCrudRepository;
    }

    @Override
    public Mono<Endereco> createEndereco(CriarEnderecoDto criarEnderecoDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Endereco endereco = objectMapper.convertValue(criarEnderecoDto, Endereco.class);
            return enderecoReactiveCrudRepository.save(endereco);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Erro ao criar endereço: " + e.getMessage());
        }
    }
}
