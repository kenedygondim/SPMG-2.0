package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.AvaliacaoClinicaJpaRepository;
import com.project.sp_medical_group.Models.AvaliacaoClinica;
import com.project.sp_medical_group.Models.AvaliacaoMedico;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Repositories.AvaliacaoClinicaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoClinicaService implements AvaliacaoClinicaRepository {
    private final AvaliacaoClinicaJpaRepository avaliacaoClinicaJpaRepository;
    private final EntityManager entityManager;

    @Autowired
    public AvaliacaoClinicaService(AvaliacaoClinicaJpaRepository avaliacaoClinicaJpaRepository, EntityManager entityManager) {
        this.avaliacaoClinicaJpaRepository = avaliacaoClinicaJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public AvaliacaoClinica createAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto) {
        return null;
    }

    @Override
    public List<AvaliacaoClinica> getAllAvaliacoesClinicaByClinicaId(Long clinicaId) {
        return avaliacaoClinicaJpaRepository.findByClinicaClinicaId(clinicaId);
    }

    @Override
    public List<AvaliacaoClinica> getAllAvaliacoesClinicaByPacienteId(Long pacienteId) {
        return List.of();
    }

    @Override
    public AvaliacaoClinica addAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto) {
        Integer numeroConsultas = avaliacaoClinicaJpaRepository.contarConsultas(avaliarClinicaDto.clinicaId(), avaliarClinicaDto.pacienteId());

        if (numeroConsultas < 1) {
            throw new BusinessException("Não é possível avaliar pois o paciente não possui consultas concluídas realizadas na clínica selecionada." );
        }

        Optional<AvaliacaoClinica> avaliacaoClinicaExistente = avaliacaoClinicaJpaRepository.findByClinicaClinicaIdAndPacientePacienteId(avaliarClinicaDto.clinicaId(), avaliarClinicaDto.pacienteId());

        if (avaliacaoClinicaExistente.isPresent()) {
            avaliacaoClinicaExistente.get().setNumeroEstrelas(avaliarClinicaDto.numeroEstrelas());
            avaliacaoClinicaExistente.get().setComentario(avaliarClinicaDto.comentario());

            System.out.println("Atualizando avaliação médica existente: " + avaliacaoClinicaExistente.get().toString());

            return avaliacaoClinicaJpaRepository.save(avaliacaoClinicaExistente.get());
        }

        AvaliacaoClinica avaliacaoClinica = new AvaliacaoClinica();
        try {
            Clinica clinicaReference = entityManager.getReference(Clinica.class, avaliarClinicaDto.clinicaId());
            Paciente pacienteReference = entityManager.getReference(Paciente.class, avaliarClinicaDto.pacienteId());
            avaliacaoClinica.setClinica(clinicaReference);
            avaliacaoClinica.setPaciente(pacienteReference);
            avaliacaoClinica.setNumeroEstrelas(avaliarClinicaDto.numeroEstrelas());
            avaliacaoClinica.setComentario(avaliarClinicaDto.comentario());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Paciente ou clínica não encontrados: " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("Erro ao criar avaliação clínica: " + e.getMessage());
        }

        return avaliacaoClinicaJpaRepository.save(avaliacaoClinica);
    }
}
