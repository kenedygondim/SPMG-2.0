package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarDisponibilidadeDto;
import com.project.sp_medical_group.Jpa.Repositories.DisponibilidadeJpaRepository;
import com.project.sp_medical_group.Models.Disponibilidade;
import com.project.sp_medical_group.Repositories.DisponibilidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spmg/disponibilidades")
public class DisponibilidadeController {
    private final DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    public DisponibilidadeController(DisponibilidadeRepository disponibilidadeRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    @GetMapping("/getAllDisponibilidadesByMedicoCpfAndDataDisp")
    public List<Disponibilidade> getAllDisponibilidadesByMedicoCpfAndDataDisp(@RequestParam Long medicoId,
                                                                              @RequestParam String dataDisp) {
        return disponibilidadeRepository.getAllDisponibilidadesByMedicoIdAndDataDisp(medicoId, dataDisp);
    }

    @PostMapping("/createDisponibilidade")
    public ResponseEntity<String> createDisponibilidade(@RequestBody @Valid CriarDisponibilidadeDto criarDisponibilidadeDto) {
        disponibilidadeRepository.createDisponibilidade(criarDisponibilidadeDto);
        return ResponseEntity.status(201).body("Disponibilidade adicionada com sucesso!\n Horário: " + criarDisponibilidadeDto.horaInicio() + " - " + criarDisponibilidadeDto.horaFim() + "\n Data: " + criarDisponibilidadeDto.dataDisp());
    }
}
