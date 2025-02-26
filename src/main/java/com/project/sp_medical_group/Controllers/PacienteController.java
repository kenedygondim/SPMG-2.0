package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Services.PacienteService;
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
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/getAllPacientes")
    public Mono<ResponseEntity<Flux<Paciente>>> getAllPacientes() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(pacienteService.getAllPacientes()));
    }

    @PostMapping("/createPaciente")
    public Mono<ResponseEntity<String>> createPaciente(@RequestBody @Valid CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto) {
        return pacienteService.createPaciente(criarPessoaUsuarioEnderecoDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
                            .body("Paciente adicionado com sucesso!")
        );
    }
}
