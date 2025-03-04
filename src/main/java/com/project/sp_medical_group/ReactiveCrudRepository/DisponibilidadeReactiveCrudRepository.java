package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Disponibilidade;

import reactor.core.publisher.Flux;

public interface DisponibilidadeReactiveCrudRepository extends ReactiveCrudRepository<Disponibilidade, Integer> { 
    Flux<Disponibilidade> findAllByMedicoCpf(String medicoCpf);
}
