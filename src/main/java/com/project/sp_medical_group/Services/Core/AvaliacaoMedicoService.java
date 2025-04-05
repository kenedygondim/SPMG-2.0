package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Models.AvaliacaoMedico;
import com.project.sp_medical_group.Repositories.AvaliacaoMedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoMedicoService implements AvaliacaoMedicoRepository {
    @Override
    public AvaliacaoMedico createAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto) {
        return null;
    }

    @Override
    public List<AvaliacaoMedico> getAllAvaliacoesMedicoByMedicoCrm(String medicoCrm) {
        return List.of();
    }

    @Override
    public List<AvaliacaoMedico> getAllAvaliacoesMedicoByPacienteCpf(String pacienteCpf) {
        return List.of();
    }
}
