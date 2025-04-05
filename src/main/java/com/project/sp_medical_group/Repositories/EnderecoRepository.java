package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarEnderecoDto;
import com.project.sp_medical_group.Models.Endereco;

public interface EnderecoRepository {
    public abstract Endereco createEndereco(CriarEnderecoDto criarEnderecoDto);
}
