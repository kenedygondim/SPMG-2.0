package com.project.sp_medical_group.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Repositories.EspecialidadeRepository;
import com.project.sp_medical_group.Repositories.MedicoEspecialidadeRepository;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/spmg/especialidades")
public class EspecialidadeController {
    private final EspecialidadeRepository especialidadeRepository;
    private final MedicoEspecialidadeRepository medicoEspecialidadeRepository;

    @Autowired
    public EspecialidadeController(EspecialidadeRepository especialidadeRepository, MedicoEspecialidadeRepository medicoEspecialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
        this.medicoEspecialidadeRepository = medicoEspecialidadeRepository;
    }

    @GetMapping("/getAllEspecialidades")
    public Mono<ResponseEntity<Flux<Especialidade>>> getAllEspecialidades() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(especialidadeRepository.getAllEspecialidades()));
    }

    @PostMapping("/createEspecialidade")
    public Mono<ResponseEntity<String>> createEspecialidade(@RequestBody @Valid CriarEspecialidadeDto criarEspecialidadeDto) {
        return especialidadeRepository.createEspecialidade(criarEspecialidadeDto)
            .map(especialidade -> ResponseEntity.status(HttpStatus.CREATED)
                .body("Especialidade adicionada com sucesso!"));
    }

    @PostMapping("/associateMedicoEspecialidade")
    public Mono<ResponseEntity<String>> associarMedicoEspecialidade(@RequestBody @Valid AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto) {
        return medicoEspecialidadeRepository.associateMedicoEspecialidade(associarMedicoEspecialidadeDto)
            .map(especialidade -> ResponseEntity.status(HttpStatus.CREATED)
                .body("Especialidade associada ao médico com sucesso!"));
    }
}
