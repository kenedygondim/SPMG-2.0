package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioEnderecoDto;
import com.project.sp_medical_group.Models.Paciente;

import java.util.List;

public interface PacienteRepository {
    public abstract List<Paciente> getAllPacientes();
    public abstract Paciente createPaciente(CriarPessoaUsuarioEnderecoDto criarPessoaUsuarioEnderecoDto);
}
