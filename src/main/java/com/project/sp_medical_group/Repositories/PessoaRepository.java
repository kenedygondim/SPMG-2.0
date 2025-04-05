package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaDto;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.Models.Pessoa;

import java.util.List;

public interface PessoaRepository {
    public abstract List<Pessoa> getAllPessoas();
    public abstract Pessoa createPessoa(CriarPessoaDto criarPessoaDto, Endereco endereco);
}
