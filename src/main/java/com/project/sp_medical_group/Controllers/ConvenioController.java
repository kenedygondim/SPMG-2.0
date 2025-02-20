package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.Services.ConvenioService;
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

    private final ConvenioService convenioService;

    @Autowired
    public ConvenioController(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }

    @PostMapping("/createConvenio")
    public ResponseEntity<String> createConvenio(@RequestBody @Valid CriarConvenioDto criarConvenioDto) {
        convenioService.createConvenio(criarConvenioDto);
        return ResponseEntity.ok("Convenio adicionado com sucesso!");
    }

    @GetMapping("/getAllConvenios")
    public ResponseEntity<List<Convenio>> getAllConvenios() {
        List<Convenio> convenios = convenioService.getAllConvenios();
        return ResponseEntity.ok(convenios);
    }
}
