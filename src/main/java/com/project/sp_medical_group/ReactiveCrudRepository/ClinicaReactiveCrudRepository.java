package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Clinica;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ClinicaReactiveCrudRepository extends ReactiveCrudRepository<Clinica, String> {
    Mono<Clinica> findByCnpj(String cnpj);
    Mono<Clinica> findByNomeFantasia(String nomeFantasia);
    Mono<Clinica> findByRazaoSocial(String razaoSocial);

    // Método abaixo serve para contornar comportamento padrão do R2DBC de atualizar registros que possuem chave primária já definida ao invés de criá-los
    @Query("INSERT INTO tb_clinicas (cnpj, nome_fantasia, razao_social, endereco_id) VALUES (:cnpj, :nomeFantasia, :razaoSocial, :enderecoId)")
    Mono<Void> insertClinica(String cnpj, String nomeFantasia, String razaoSocial, Integer enderecoId);

}

