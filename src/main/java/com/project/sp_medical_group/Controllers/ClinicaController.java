package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;
import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Repositories.ClinicaRepository;
import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;

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
    private final ClinicaRepository clinicaRepository;
    private final MedicoClinicaRepository medicoClinicaRepository;

    @Autowired
    public ClinicaController(ClinicaRepository clinicaRepository, MedicoClinicaRepository medicoClinicaRepository) {
        this.clinicaRepository = clinicaRepository;
        this.medicoClinicaRepository = medicoClinicaRepository;
    }

    @GetMapping("/getAllClinicas")
    public Mono<ResponseEntity<Flux<Clinica>>> getAllClinicas() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(clinicaRepository.getAllClinicas()));
    }

    @PostMapping("/createClinica")
    public Mono<ResponseEntity<String>> createClinica(@RequestBody @Valid CriarClinicaEnderecoDto criarClinicaEnderecoDto) {
        return clinicaRepository.createClinica(criarClinicaEnderecoDto)
            .map(clinicaSalva -> ResponseEntity.status(HttpStatus.CREATED).body("Clínica criada com sucesso"));
    }

    @PostMapping("/associateMedicoClinica")
    public Mono<ResponseEntity<String>> associateMedicoClinica(@RequestBody @Valid AssociarMedicoClinicaDto associarMedicoClinicaDto) {
        return medicoClinicaRepository.associateMedicoClinica(associarMedicoClinicaDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
            .body("Médico adicionado a clínica com sucesso!")
        );
    }

}
