package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Models.AvaliacaoMedico;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AvaliacaoMedicoRepository {
    public abstract AvaliacaoMedico createAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto);
    public abstract List<AvaliacaoMedico> getAllAvaliacoesMedicoByMedicoCrm(String medicoCrm);
    public abstract List<AvaliacaoMedico> getAllAvaliacoesMedicoByPacienteCpf(String pacienteCpf);
    public abstract AvaliacaoMedico addAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto);
}
