package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Models.MedicoEspecialidade;
import com.project.sp_medical_group.Repositories.*;
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
    private final MedicoEspecialidadeRepository medicoEspecialidadeRepository;
    private final AvaliacaoMedicoRepository avaliacaoMedicoRepository;


    @Autowired
    public MedicoController(MedicoRepository medicoRepository,
                            MedicoConvenioRepository medicoConvenioRepository,
                            AvaliacaoMedicoRepository avaliacaoMedicoRepository,
                            MedicoEspecialidadeRepository medicoEspecialidadeRepository) {
        this.medicoRepository = medicoRepository;
        this.medicoConvenioRepository = medicoConvenioRepository;
        this.avaliacaoMedicoRepository = avaliacaoMedicoRepository;
        this.medicoEspecialidadeRepository = medicoEspecialidadeRepository;
    }

    @GetMapping("/getAllMedicos")
    public ResponseEntity<List<Medico>> getAllMedicos() {
        return ResponseEntity.ok(medicoRepository.getAllMedicos());
    }

    @GetMapping("/getAllMedicoEspecialidadesByMedicoCpf")
    public ResponseEntity<List<MedicoEspecialidade>> getAllMedicoEspecialidadesByMedicoCpf(@RequestParam Long medicoId) {
        return ResponseEntity.ok(medicoEspecialidadeRepository.getAllMedicoEspecialidadesByMedicoId(medicoId));
    }

    @PostMapping("/createMedico")
    public ResponseEntity<String> createMedico(@RequestBody @Valid CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        medicoRepository.createMedico(criarPessoaUsuarioMedicoEnderecoDto);
        return ResponseEntity.status(201).body("Médico criado com sucesso!");
    }

    @PostMapping("/addAvaliacaoMedico")
    public ResponseEntity<String> addAvaliacaoMedico(@RequestBody @Valid AvaliarMedicoDto avaliarMedicoDto) {
        avaliacaoMedicoRepository.addAvaliacaoMedico(avaliarMedicoDto);
        return ResponseEntity.ok("Avaliação adicionada com sucesso!");
    }

    @PostMapping("/associateMedicoEspecialidade")
    public ResponseEntity<String> associateMedicoEspecialidade(@RequestBody @Valid AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto) {
        System.out.println("Associando médico e especialidade: " + associarMedicoEspecialidadeDto);
        medicoEspecialidadeRepository.associateMedicoEspecialidade(associarMedicoEspecialidadeDto);
        return ResponseEntity.status(201).body("Especialidade atribuída ao médico com sucesso!");
    }
}
