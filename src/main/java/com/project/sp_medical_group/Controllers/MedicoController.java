package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Repositories.AvaliacaoMedicoRepository;
import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;
import com.project.sp_medical_group.Repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/medicos")
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
    public ResponseEntity<List<Medico>> getAllMedicos() {
        return ResponseEntity.ok(medicoRepository.getAllMedicos());
    }

    @PostMapping("/createMedico")
    public ResponseEntity<Medico> createMedico(@RequestBody @Valid CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        return ResponseEntity.status(201).body(medicoRepository.createMedico(criarPessoaUsuarioMedicoEnderecoDto));
    }
}
