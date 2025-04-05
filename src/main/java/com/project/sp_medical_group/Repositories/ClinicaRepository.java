package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarClinicaEnderecoDto;
import com.project.sp_medical_group.Models.Clinica;

import java.util.List;

public interface ClinicaRepository {
    public abstract List<Clinica> getAllClinicas();
    public abstract Clinica createClinica(CriarClinicaEnderecoDto criarClinicaEnderecoDto);
}
