package com.project.sp_medical_group.ReactiveCrudRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.AvaliacaoMedico;

import reactor.core.publisher.Mono;

public interface AvaliacaoMedicoReactiveCrudRepository extends ReactiveCrudRepository<AvaliacaoMedico, Integer> {
    Mono<AvaliacaoMedico> findByMedicoCpfAndPacienteCpf(String medicoCpf, String pacienteCpf);
}
