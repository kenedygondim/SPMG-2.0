package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.AdicionarSaudeObservacaoDto;
import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Repositories.PacienteRepository;
import com.project.sp_medical_group.Repositories.SaudeObservacoesRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


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
    public Mono<ResponseEntity<Flux<Paciente>>> getAllPacientes() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.getAllPacientes()));
    }

    @PostMapping("/createPaciente")
    public Mono<ResponseEntity<String>> createPaciente(@RequestBody @Valid CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto) {
        return pacienteRepository.createPaciente(criarPessoaUsuarioEnderecoDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
                            .body("Paciente adicionado com sucesso!")
        );
    }

    @PostMapping("/addSaudeObservacao")
    public Mono<ResponseEntity<String>> addSaudeObservacao (@RequestParam String pacienteCpf, @RequestBody AdicionarSaudeObservacaoDto adicionarSaudeObservacaoDto) {
        return saudeObservacoesRepository.addSaudeObservacao (pacienteCpf, adicionarSaudeObservacaoDto)
        .map(registro -> ResponseEntity.status(HttpStatus.CREATED)
            .body("Observações de saúde adicionadas com sucesso"));
    }
}
