package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Dto.MedicosDetalhesDto;
import com.project.sp_medical_group.Models.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository {
    public abstract List<Medico> getAllMedicos();
    public abstract Medico createMedico(CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto);
    public abstract List<MedicosDetalhesDto> getMedicoDetalhes(String convenioNome, String especialidadeNome);
}
