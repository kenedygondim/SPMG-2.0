package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.MedicoConvenio;

import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MedicoConvenioReactiveCrudRepository extends ReactiveCrudRepository<MedicoConvenio, Void> {	
    @Query("INSERT INTO tb_medico_convenios (convenio_id, medico_cpf) VALUES (:convenioId, :medicoCpf)")
    Mono<Void> insertMedicoConvenio(Integer convenioId, String medicoCpf);
}
