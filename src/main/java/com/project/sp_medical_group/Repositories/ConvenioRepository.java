package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ConvenioRepository {
    public abstract Mono<Convenio> createConvenio (CriarConvenioDto criarConvenioDto);
    public abstract Flux<Convenio> getAllConvenios();
}
