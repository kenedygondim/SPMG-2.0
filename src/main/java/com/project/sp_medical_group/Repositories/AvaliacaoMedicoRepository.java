package com.project.sp_medical_group.Repositories;

import org.springframework.stereotype.Repository;

import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Models.AvaliacaoMedico;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AvaliacaoMedicoRepository {
    public abstract Mono<AvaliacaoMedico> createAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto);
    public abstract Flux<AvaliacaoMedico> getAllAvaliacoesMedicoByMedicoCrm(String medicoCrm);
    public abstract Flux<AvaliacaoMedico> getAllAvaliacoesMedicoByPacienteCpf(String pacienteCpf);
}
