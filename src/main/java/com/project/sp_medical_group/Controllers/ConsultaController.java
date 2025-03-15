package com.project.sp_medical_group.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Models.Consulta;
import com.project.sp_medical_group.Repositories.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/spmg/consultas")
public class ConsultaController {
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @PostMapping("/createConsulta")
    public Mono<ResponseEntity<String>> createConsulta(@RequestBody @Valid AgendarConsultaDto agendarConsultaDto) {
        return consultaRepository.createConsulta(agendarConsultaDto)
            .map(consulta -> ResponseEntity.status(HttpStatus.CREATED)
                .body("Consulta agendada com sucesso!"));
    }

    @GetMapping("/getAllConsultasByPacienteCpf")
    public Mono<ResponseEntity<Flux<Consulta>>> getAllConsultasByPacienteCpf(@RequestParam String pacienteCpf) {
        System.out.println("Paciente CPF: " + pacienteCpf);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(consultaRepository.getAllConsultasByPacienteCpf(pacienteCpf)));
    }

    @DeleteMapping("/cancelConsulta")
    public Mono<ResponseEntity<String>> cancelConsulta(@RequestParam Integer consultaId) {
        return consultaRepository.cancelConsulta(consultaId)
            .map(consulta -> ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Consulta cancelada com sucesso!"));
    }
}
