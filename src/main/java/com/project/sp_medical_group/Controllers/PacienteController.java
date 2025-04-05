package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Repositories.PacienteRepository;
import com.project.sp_medical_group.Repositories.SaudeObservacoesRepository;
import com.project.sp_medical_group.Services.Core.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/pacientes")
public class PacienteController {
    private final PacienteRepository pacienteRepository;
    private final SaudeObservacoesRepository saudeObservacoesRepository;

    @Autowired
    public PacienteController(PacienteRepository pacienteRepository, SaudeObservacoesRepository saudeObservacoesRepository) {
        this.pacienteRepository = pacienteRepository;
        this.saudeObservacoesRepository = saudeObservacoesRepository;
    }

    @GetMapping("/getAllPacientes")
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping("/createPaciente")
    public ResponseEntity<String> createPaciente(@RequestBody @Valid CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto) {

        System.out.println(criarPessoaUsuarioEnderecoDto);

        pacienteRepository.createPaciente(criarPessoaUsuarioEnderecoDto);
        return ResponseEntity.ok("Paciente adicionado com sucesso!");
    }
}
