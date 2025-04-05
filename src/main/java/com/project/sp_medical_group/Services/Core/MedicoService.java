package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.CriarPessoaUsuarioMedicoEnderecoDto;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService implements MedicoRepository {
    @Override
    public List<Medico> getAllMedicos() {
        return List.of();
    }

    @Override
    public Medico createMedico(CriarPessoaUsuarioMedicoEnderecoDto criarPessoaUsuarioMedicoEnderecoDto) {
        return null;
    }
}
