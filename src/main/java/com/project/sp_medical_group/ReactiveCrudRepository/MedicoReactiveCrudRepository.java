package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Medico;

import reactor.core.publisher.Mono;

public interface MedicoReactiveCrudRepository extends ReactiveCrudRepository<Medico, String> {
    @Query ("INSERT INTO tb_medicos (cpf, usuario_id, crm) VALUES (:cpf, :usuarioId, :crm)")
    Mono<Void> insertMedico(String cpf, Integer usuarioId, String crm);
}