package com.project.sp_medical_group.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Services.MedicoConvenioService;
import com.project.sp_medical_group.Services.MedicoService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/spmg/medicos")
@Validated
public class MedicoController {
    private final MedicoService medicoService;
    private final MedicoConvenioService medicoConvenioService;

    @Autowired
    public MedicoController(MedicoService medicoService, MedicoConvenioService medicoConvenioService) {
        this.medicoService = medicoService;
        this.medicoConvenioService = medicoConvenioService;
    }

    @GetMapping("/getAllMedicos")
    public Mono<ResponseEntity<Flux<Medico>>> getAllMedicos() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(medicoService.getAllMedicos()));
    }

    @PostMapping("/createMedico")
    public Mono<ResponseEntity<String>> createMedico(@RequestBody @Valid CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        return medicoService.createMedico(criarPessoaUsuarioMedicoEnderecoDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
                            .body("Médico adicionado com sucesso!")
        );
    }

    // @PostMapping("/associateMedicoConvenio")
    // public Mono<ResponseEntity<String>> associarConvenio(@RequestBody @Valid ) {
    //     return medicoService.associateMedicoConvenio()
        
    // }
}
