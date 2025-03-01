package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.MedicoClinica;

import reactor.core.publisher.Mono;

public interface MedicoClinicaReactiveCrudRepository extends ReactiveCrudRepository<MedicoClinica, Void> {
    @Query("INSERT INTO tb_medico_clinicas (clinica_cnpj, medico_cpf) VALUES (:clinicaCnpj, :medicoCpf)")   
    Mono<Void> insertMedicoClinica(String clinicaCnpj, String medicoCpf);
}