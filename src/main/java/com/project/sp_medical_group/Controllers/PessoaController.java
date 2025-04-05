package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Models.Pessoa;
import com.project.sp_medical_group.Repositories.PessoaRepository;
import com.project.sp_medical_group.Services.Core.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spmg/pessoas")
public class PessoaController {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    @GetMapping("/getAllPessoas")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = pessoaRepository.getAllPessoas();
        return ResponseEntity.ok(pessoas);
    }

//    @PostMapping("/createPessoa")
//    public ResponseEntity<String> createPessoa(Pessoa pessoa) {
//        pessoaService.createPessoa(pessoa);
//        return ResponseEntity.ok("Pessoa adicionada com sucesso!");
//    }
}