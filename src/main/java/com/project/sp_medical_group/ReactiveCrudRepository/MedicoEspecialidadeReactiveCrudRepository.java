package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.MedicoEspecialidade;

import reactor.core.publisher.Mono;

public interface MedicoEspecialidadeReactiveCrudRepository extends ReactiveCrudRepository<MedicoEspecialidade, Void> {
    @Query("INSERT INTO tb_medico_especialidades (especialidade_id, medico_cpf, valor_procedimento) VALUES (:especialidadeId, :medicoCpf, :valorProcedimento)")
    Mono<Void> insertMedicoEspecialidade(Integer especialidadeId, String medicoCpf, Double valorProcedimento);
}
