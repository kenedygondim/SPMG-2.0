package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.Repositories.ConvenioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/spmg/convenios")
@Validated
public class ConvenioController {

    private final ConvenioRepository convenioRepository;

    @Autowired
    public ConvenioController(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }

    @PostMapping("/createConvenio")
    public Mono<ResponseEntity<String>> createConvenio(@RequestBody @Valid CriarConvenioDto criarConvenioDto) {
        return convenioRepository.createConvenio(criarConvenioDto)
        .map(convenio -> ResponseEntity.status(HttpStatus.CREATED).body("Convenio adicionado com sucesso!"));
    }

    @GetMapping("/getAllConvenios")
    public Mono<ResponseEntity<Flux<Convenio>>> getAllConvenios() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(convenioRepository.getAllConvenios()));
    }
}
