package com.project.sp_medical_group.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.Repositories.DisponibilidadeRepository;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("spmg/disponibilidades")
public class DisponibilidadeController {
    private final DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    public DisponibilidadeController(DisponibilidadeRepository disponibilidadeRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    @PostMapping("/createDisponibilidade")
    public Mono<ResponseEntity<String>> createDisponibilidade(@RequestBody @Valid CriarDisponibilidadeDto criarDisponibilidadeDto) {
        return disponibilidadeRepository.createDisponibilidade(criarDisponibilidadeDto)
            .map(disponibilidade -> ResponseEntity.status(HttpStatus.CREATED)
                .body("Disponibilidade adicionada com sucesso!"));
    }

    @GetMapping("/getAllDisponibilidadesByMedicoCpf")
    public Mono<ResponseEntity<Flux<Disponibilidade>>> getAllDisponibilidadesByMedicoCpf(@RequestParam String medicoCpf) {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(disponibilidadeRepository.getAllDisponibilidadesByMedicoCpf(medicoCpf)));
    }
}



