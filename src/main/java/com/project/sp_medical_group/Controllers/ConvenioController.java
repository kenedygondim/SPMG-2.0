package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.Services.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/spmg/convenios")
@Validated
public class ConvenioController {

    private final ConvenioService convenioService;

    @Autowired
    public ConvenioController(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }

    @PostMapping("/createConvenio")
    public Mono<ResponseEntity<String>> createConvenio(@RequestBody @Valid CriarConvenioDto criarConvenioDto) {
        return convenioService.createConvenio(criarConvenioDto)
        .map(convenio -> ResponseEntity.ok("Convenio adicionado com sucesso!"))
        .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }

    @GetMapping("/getAllConvenios")
    public ResponseEntity<Flux<Convenio>> getAllConvenios() {
        Flux<Convenio> convenios = convenioService.getAllConvenios();
        return ResponseEntity.ok(convenios);
    }
}
