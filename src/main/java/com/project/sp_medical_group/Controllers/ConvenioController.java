package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.Repositories.ConvenioRepository;
import com.project.sp_medical_group.Services.Core.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spmg/convenios")
@Validated
public class ConvenioController {

    private final ConvenioRepository convenioRepository;

    @Autowired
    public ConvenioController(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }

    @PostMapping("/createConvenio")
    public ResponseEntity<String> createConvenio(@RequestBody @Valid CriarConvenioDto criarConvenioDto) {
        convenioRepository.createConvenio(criarConvenioDto);
        return ResponseEntity.ok("Convenio adicionado com sucesso!");
    }

    @GetMapping("/getAllConvenios")
    public ResponseEntity<List<Convenio>> getAllConvenios() {
        List<Convenio> convenios = convenioRepository.getAllConvenios();
        return ResponseEntity.ok(convenios);
    }
}
