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
    private final ObjectMapper objectMapper;

    @Autowired
    public EnderecoService(EnderecoReactiveCrudRepository enderecoReactiveCrudRepository, ObjectMapper objectMapper) {
        this.enderecoReactiveCrudRepository = enderecoReactiveCrudRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Endereco> createEndereco(CriarEnderecoDto criarEnderecoDto) {
        return Mono.fromCallable(() -> objectMapper.convertValue(criarEnderecoDto, Endereco.class))
                .onErrorMap(IllegalArgumentException.class, e -> new BusinessException("Erro ao criar converter Dto, verifique os dados enviados: " + e.getMessage()))
                .flatMap(endereco -> enderecoReactiveCrudRepository.save(endereco))
                .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar endereço: " + e.getMessage()));
    }
}
