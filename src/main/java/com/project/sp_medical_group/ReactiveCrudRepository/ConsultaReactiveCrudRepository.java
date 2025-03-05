package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Consulta;

import reactor.core.publisher.Flux;

public interface ConsultaReactiveCrudRepository extends ReactiveCrudRepository<Consulta, Integer> {
    Flux<Consulta> findAllByPacienteCpf(String pacienteCpf);
}
