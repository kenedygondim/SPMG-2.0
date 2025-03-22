package com.project.sp_medical_group.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;
import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Repositories.AvaliacaoMedicoRepository;
import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;
import com.project.sp_medical_group.Repositories.MedicoRepository;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/spmg/medicos")
@Validated
public class MedicoController {
    private final MedicoRepository medicoRepository;
    private final MedicoConvenioRepository medicoConvenioRepository;
    private final AvaliacaoMedicoRepository avaliacaoMedicoRepository;


    @Autowired
    public MedicoController(MedicoRepository medicoRepository, MedicoConvenioRepository medicoConvenioRepository, AvaliacaoMedicoRepository avaliacaoMedicoRepository) {
        this.medicoRepository = medicoRepository;
        this.medicoConvenioRepository = medicoConvenioRepository;
        this.avaliacaoMedicoRepository = avaliacaoMedicoRepository;
    }

    @GetMapping("/getAllMedicos")
    public Mono<ResponseEntity<Flux<Medico>>> getAllMedicos() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(medicoRepository.getAllMedicos()));
    }

    @PostMapping("/createMedico")
    public Mono<ResponseEntity<String>> createMedico(@RequestBody @Valid CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        return medicoRepository.createMedico(criarPessoaUsuarioMedicoEnderecoDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
            .body("Médico adicionado com sucesso!")
        );
    }

    @PostMapping("/associateMedicoConvenio")
    public Mono<ResponseEntity<String>> associarConvenio(@RequestBody @Valid AssociarMedicoConvenioDto associarMedicoConvenioDto) {
        return medicoConvenioRepository.associateMedicoConvenio(associarMedicoConvenioDto)
        .map(paciente -> ResponseEntity.status(HttpStatus.CREATED)
            .body("Convênio associado ao médico com sucesso!")
        );
    }

    @PostMapping("/addAvaliacaoMedico")
    public Mono<ResponseEntity<String>> addAvaliacaoMedico(@RequestBody @Valid AvaliarMedicoDto avaliarMedicoDto) {
        return avaliacaoMedicoRepository.createAvaliacaoMedico(avaliarMedicoDto)
            .map(avaliacao -> ResponseEntity.status(HttpStatus.CREATED)
                .body("Avaliação do médico criada com sucesso!")
            );
    }
}
