package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarClinicaComEnderecoDto;
import com.project.sp_medical_group.Dto.CriarClinicaDto;
import com.project.sp_medical_group.Dto.CriarEnderecoDto;
import com.project.sp_medical_group.Jpa.Repositories.ClinicaJpaRepository;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Services.ClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Clinica>> getAllClinicas() {
        List<Clinica> clinicas = clinicaService.getAllClinicas();
        return ResponseEntity.ok(clinicas);
    }

    @PostMapping("/createClinica")
    public ResponseEntity<String> createClinica(@RequestBody @Valid CriarClinicaComEnderecoDto criarClinicaComEnderecoDto) {
//        System.out.println(criarClinicaComEnderecoDto);
//        return ResponseEntity.ok("ok");
        clinicaService.createClinica(criarClinicaComEnderecoDto);
        return ResponseEntity.ok("Clinica adicionada com sucesso!");
    }
}
