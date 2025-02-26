package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Paciente;

import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PacienteReactiveCrudRepository extends ReactiveCrudRepository<Paciente, String> {
    @Query("INSERT INTO tb_pacientes (cpf, usuario_id) VALUES (:cpf, :usuarioId)")
    Mono<Void> insertPaciente(String cpf, Integer usuarioId);
}
