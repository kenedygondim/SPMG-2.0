package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Models.AvaliacaoClinica;
import com.project.sp_medical_group.Repositories.AvaliacaoClinicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoClinicaService implements AvaliacaoClinicaRepository {
    @Override
    public AvaliacaoClinica createAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto) {
        return null;
    }

    @Override
    public List<AvaliacaoClinica> getAllAvaliacoesClinicaByClinicaCnpj(String clinicaCnpj) {
        return List.of();
    }

    @Override
    public List<AvaliacaoClinica> getAllAvaliacoesClinicaByPacienteCpf(String pacienteCpf) {
        return List.of();
    }
}
