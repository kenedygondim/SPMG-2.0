package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Models.Consulta;
import com.project.sp_medical_group.Repositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/consultas")
public class ConsultaController {
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @GetMapping("/getAllConsultasByPacienteCpf")
    public ResponseEntity<List<Consulta>> getAllConsultasByPacienteCpf(@RequestParam String pacienteCpf) {
        return ResponseEntity.ok(consultaRepository.getAllConsultasByPacienteCpf(pacienteCpf));
    }

    @PostMapping("/createConsulta")
    public ResponseEntity<Consulta> createConsulta(@RequestBody @Valid AgendarConsultaDto agendarConsultaDto) {
        return ResponseEntity.status(201).body(consultaRepository.createConsulta(agendarConsultaDto));
    }
}
