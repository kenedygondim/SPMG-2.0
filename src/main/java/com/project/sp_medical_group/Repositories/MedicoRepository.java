package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;

import java.util.List;

public interface MedicoRepository {
    public abstract List<Medico> getAllMedicos();
    public abstract Medico createMedico(CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto);
}
