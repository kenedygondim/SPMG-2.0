package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Dto.AvaliarMedicoDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.AvaliacaoMedicoJpaRepository;
import com.project.sp_medical_group.Models.*;
import com.project.sp_medical_group.Repositories.AvaliacaoMedicoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoMedicoService implements AvaliacaoMedicoRepository {

    private final AvaliacaoMedicoJpaRepository avaliacaoMedicoJpaRepository;
    private final EntityManager entityManager;

    @Autowired
    public AvaliacaoMedicoService(AvaliacaoMedicoJpaRepository avaliacaoMedicoJpaRepository, EntityManager entityManager) {
        this.avaliacaoMedicoJpaRepository = avaliacaoMedicoJpaRepository;
        this.entityManager = entityManager;
    }

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

    @Override
    public AvaliacaoMedico addAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto) {
        //TO-DO: Implementar validação para não permitir que o paciente avalie o médico mais de uma vez. Ao invés disso, o paciente deve editar a avaliação já existente.
        Integer numeroConsultas = avaliacaoMedicoJpaRepository.contarConsultas(avaliarMedicoDto.medicoCpf(), avaliarMedicoDto.pacienteCpf());

        if (numeroConsultas < 1) {
            throw new BusinessException("Não é possível avaliar pois o paciente não possui consultas concluídas com o médico selecionado." );
        }

        AvaliacaoMedico avaliacaoMedico = new AvaliacaoMedico();
        try {
            Medico medicoReference = entityManager.getReference(Medico.class, avaliarMedicoDto.medicoCpf());
            Paciente pacienteReference = entityManager.getReference(Paciente.class, avaliarMedicoDto.pacienteCpf());
            avaliacaoMedico.setMedico(medicoReference);
            avaliacaoMedico.setPaciente(pacienteReference);
            avaliacaoMedico.setNumeroEstrelas(avaliarMedicoDto.numeroEstrelas());
            avaliacaoMedico.setComentario(avaliarMedicoDto.comentario());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Paciente ou médico não encontrados: " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Erro ao criar avaliação clínica: " + e.getMessage());
        }

        return avaliacaoMedicoJpaRepository.save(avaliacaoMedico);
    }
}
