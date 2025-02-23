package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Services.ClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/spmg/clinicas")
public class ClinicaController {
    private final ClinicaService clinicaService;

    @Autowired
    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @GetMapping("/getAllClinicas")
    public ResponseEntity<Flux<Clinica>> getAllClinicas() {
        Flux<Clinica> clinicas = clinicaService.getAllClinicas();
        return ResponseEntity.ok(clinicas);
    }

    @PostMapping("/createClinica")
    public ResponseEntity<String> createClinica(@RequestBody @Valid CriarClinicaEnderecoDto criarClinicaEnderecoDto) {
        clinicaService.createClinica(criarClinicaEnderecoDto);
        return ResponseEntity.ok("Clinica adicionada com sucesso!");
    }
}
