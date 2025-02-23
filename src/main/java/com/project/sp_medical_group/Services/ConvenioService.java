package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.ReactiveCrudRepository.ConvenioReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConvenioService implements ConvenioRepository {
    private final ConvenioReactiveCrudRepository convenioReactiveCrudRepository;

    @Autowired
    public ConvenioService(ConvenioReactiveCrudRepository convenioReactiveCrudRepository) {
        this.convenioReactiveCrudRepository = convenioReactiveCrudRepository;
    }

    @Override
    public Mono<Convenio> createConvenio(CriarConvenioDto criarConvenioDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Convenio convenio = objectMapper.convertValue(criarConvenioDto, Convenio.class);
            return convenioReactiveCrudRepository.save(convenio);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe um convênio cadastrado com esse nome: " + e.getMessage());
        }
    }

    @Override
    public Flux<Convenio> getAllConvenios() {
        return convenioReactiveCrudRepository.findAll();
    }
}
