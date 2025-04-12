package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Models.AvaliacaoClinica;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Repositories.AvaliacaoClinicaRepository;
import com.project.sp_medical_group.Repositories.ClinicaRepository;

import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/clinicas")
public class ClinicaController {
    private final ClinicaRepository clinicaRepository;
    private final MedicoClinicaRepository medicoClinicaRepository;
    private final AvaliacaoClinicaRepository avaliacaoClinicaRepository;

    @Autowired
    public ClinicaController(ClinicaRepository clinicaRepository, MedicoClinicaRepository medicoClinicaRepository, AvaliacaoClinicaRepository avaliacaoClinicaRepository) {
        this.clinicaRepository = clinicaRepository;
        this.medicoClinicaRepository = medicoClinicaRepository;
        this.avaliacaoClinicaRepository = avaliacaoClinicaRepository;
    }

    @GetMapping("/getAllClinicas")
    public ResponseEntity<List<Clinica>> getAllClinicas() {
        List<Clinica> clinicas = clinicaRepository.getAllClinicas();
        return ResponseEntity.ok(clinicas);
    }

    @PostMapping("/createClinica")
    public ResponseEntity<String> createClinica(@RequestBody @Valid CriarClinicaEnderecoDto criarClinicaEnderecoDto) {
        clinicaRepository.createClinica(criarClinicaEnderecoDto);
        return ResponseEntity.ok("Clinica adicionada com sucesso!");
    }

    @GetMapping("/getAllAvaliacoesClinicaByClinicaCnpj")
    public ResponseEntity<List<AvaliacaoClinica>> getAllAvaliacoesClinicaByClinicaCnpj(@RequestParam String clinicaCnpj) {
        List<AvaliacaoClinica> avaliacoes = avaliacaoClinicaRepository.getAllAvaliacoesClinicaByClinicaCnpj(clinicaCnpj);
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping("/addAvaliacaoClinica")
    public ResponseEntity<String> addAvaliacaoClinica(@RequestBody @Valid AvaliarClinicaDto avaliarClinicaDto) {
        avaliacaoClinicaRepository.addAvaliacaoClinica(avaliarClinicaDto);
        return ResponseEntity.ok("Avaliação adicionada com sucesso!");
    }
}
