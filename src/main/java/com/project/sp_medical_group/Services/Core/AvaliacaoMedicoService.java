package com.project.sp_medical_group.Services.Core;

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
import java.util.Optional;

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
    public List<AvaliacaoMedico> getAllAvaliacoesMedicoByMedicoId(Long medicoId) {
        return List.of();
    }

    @Override
    public List<AvaliacaoMedico> getAllAvaliacoesMedicoByPacienteId(Long pacienteId) {
        return List.of();
    }

    @Override
    public AvaliacaoMedico addAvaliacaoMedico(AvaliarMedicoDto avaliarMedicoDto) {
        Integer numeroConsultas = avaliacaoMedicoJpaRepository.contarConsultas(avaliarMedicoDto.medicoId(), avaliarMedicoDto.pacienteId());

        if (numeroConsultas < 1) {
            throw new BusinessException("Não é possível avaliar pois o paciente não possui consultas concluídas com o médico selecionado." );
        }

        Optional<AvaliacaoMedico> avaliacaoMedicoExistente = avaliacaoMedicoJpaRepository.findByMedicoMedicoIdAndPacientePacienteId(avaliarMedicoDto.medicoId(), avaliarMedicoDto.pacienteId());

        if (avaliacaoMedicoExistente.isPresent()) {
            avaliacaoMedicoExistente.get().setNumeroEstrelas(avaliarMedicoDto.numeroEstrelas());
            avaliacaoMedicoExistente.get().setComentario(avaliarMedicoDto.comentario());

            System.out.println("Atualizando avaliação médica existente: " + avaliacaoMedicoExistente.get().toString());

            return avaliacaoMedicoJpaRepository.save(avaliacaoMedicoExistente.get());
        }

        AvaliacaoMedico avaliacaoMedico = new AvaliacaoMedico();
        try {
            Medico medicoReference = entityManager.getReference(Medico.class, avaliarMedicoDto.medicoId());
            Paciente pacienteReference = entityManager.getReference(Paciente.class, avaliarMedicoDto.pacienteId());
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
