package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Pessoa;

import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PessoaReactiveCrudRepository extends ReactiveCrudRepository<Pessoa, String> {
    @Query(
    """
    INSERT INTO tb_pessoas (nome_completo, cpf, rg, sexo, numero_telefone, dt_nascimento, endereco_id)
    OUTPUT INSERTED.*
    VALUES (:nome, :cpf, :rg, :sexo, :telefone, :dataNascimento, :enderecoId)
    """
    ) //OUTPUT INSERTED.* serve para retornar o registro inserido no banco de dados
    Mono<Pessoa> insertPessoa(String nome, String cpf, String rg, String sexo, String telefone, String dataNascimento, Integer enderecoId);
 }
