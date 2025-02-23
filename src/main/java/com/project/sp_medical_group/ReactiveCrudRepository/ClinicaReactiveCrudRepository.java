package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Clinica;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ClinicaReactiveCrudRepository extends ReactiveCrudRepository<Clinica, String> {
    Mono<Clinica> findByCnpj(String cnpj);
    Mono<Clinica> findByNomeFantasia(String nomeFantasia);
    Mono<Clinica> findByRazaoSocial(String razaoSocial);
}
