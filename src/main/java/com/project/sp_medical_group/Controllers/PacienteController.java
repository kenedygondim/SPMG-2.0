package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/spmg/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/getAllPacientes")
    public ResponseEntity<Flux<Paciente>> getAllPacientes() {
        Flux<Paciente> pacientes = pacienteService.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping("/createPaciente")
    public ResponseEntity<String> createPaciente(@RequestBody @Valid CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto) {
        pacienteService.createPaciente(criarPessoaUsuarioEnderecoDto);
        return ResponseEntity.ok("Paciente adicionado com sucesso!");
    }
}
