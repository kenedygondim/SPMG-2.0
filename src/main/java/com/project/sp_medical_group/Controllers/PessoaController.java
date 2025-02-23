package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Models.Pessoa;
import com.project.sp_medical_group.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/spmg/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/getAllPessoas")
    public ResponseEntity<Flux<Pessoa>> getAllPessoas() {
        Flux<Pessoa> pessoas = pessoaService.getAllPessoas();
        return ResponseEntity.ok(pessoas);
    }

//    @PostMapping("/createPessoa")
//    public ResponseEntity<String> createPessoa(Pessoa pessoa) {
//        pessoaService.createPessoa(pessoa);
//        return ResponseEntity.ok("Pessoa adicionada com sucesso!");
//    }
}