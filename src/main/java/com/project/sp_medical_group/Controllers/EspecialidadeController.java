package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Repositories.EspecialidadeRepository;
import com.project.sp_medical_group.Repositories.MedicoEspecialidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Especialidade>> getAllEspecialidades() {
        return ResponseEntity.ok(especialidadeRepository.getAllEspecialidades());
    }

    @PostMapping("/createEspecialidade")
    public ResponseEntity<String> createEspecialidade(@RequestBody @Valid CriarEspecialidadeDto criarEspecialidadeDto) {
        especialidadeRepository.createEspecialidade(criarEspecialidadeDto);
        return ResponseEntity.status(201).body("Especialidade adicionada com sucesso!");
    }
}
