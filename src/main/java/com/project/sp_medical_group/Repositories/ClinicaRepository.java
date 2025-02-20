package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarClinicaComEnderecoDto;
import com.project.sp_medical_group.Dto.CriarClinicaDto;
import com.project.sp_medical_group.Models.Clinica;

import java.util.List;

public interface ClinicaRepository {
    List<Clinica> getAllClinicas();
    Clinica createClinica(CriarClinicaComEnderecoDto criarClinicaComEnderecoDto);
}
