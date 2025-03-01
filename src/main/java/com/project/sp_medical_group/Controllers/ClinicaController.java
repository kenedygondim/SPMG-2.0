package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;
import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;
import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Models.MedicoClinica;
import com.project.sp_medical_group.Services.ClinicaService;
import com.project.sp_medical_group.Services.MedicoClinicaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/spmg/clinicas")
@Validated
public class ClinicaController {
    private final ClinicaService clinicaService;
    private final MedicoClinicaService medicoConvenioService;

    @Autowired
    public ClinicaController(ClinicaService clinicaService, MedicoClinicaService medicoConvenioService) {
        this.clinicaService = clinicaService;
        this.medicoConvenioService = medicoConvenioService;
    }

    @GetMapping("/getAllClinicas")
    public Mono<ResponseEntity<Flux<Clinica>>> getAllClinicas() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(clinicaService.getAllClinicas()));
    }

    @PostMapping("/createClinica")
    public Mono<ResponseEntity<String>> createClinica(@RequestBody @Valid CriarClinicaEnderecoDto criarClinicaEnderecoDto) {
        return clinicaService.createClinica(criarClinicaEnderecoDto)
            .map(clinicaSalva -> ResponseEntity.status(HttpStatus.CREATED).body("Clínica criada com sucesso"));
    }

    @PostMapping("/associateMedicoClinica")
    public Mono<ResponseEntity<String>> associateMedicoClinica(@RequestBody @Valid AssociarMedicoClinicaDto associarMedicoClinicaDto) {
        return medicoConvenioService.associateMedicoClinica(associarMedicoClinicaDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
            .body("Médico adicionado a clínica com sucesso!")
        );
    }

}
