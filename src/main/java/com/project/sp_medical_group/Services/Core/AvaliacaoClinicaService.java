package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AvaliarClinicaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.AvaliacaoClinicaJpaRepository;
import com.project.sp_medical_group.Models.AvaliacaoClinica;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Models.Paciente;
import com.project.sp_medical_group.Repositories.AvaliacaoClinicaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<AvaliacaoClinica> getAllAvaliacoesClinicaByClinicaCnpj(String clinicaCnpj) {
        return avaliacaoClinicaJpaRepository.findByClinicaCnpj(clinicaCnpj);
    }

    @Override
    public List<AvaliacaoClinica> getAllAvaliacoesClinicaByPacienteCpf(String pacienteCpf) {
        return List.of();
    }

    // Débito: Na tabela consulta não tem nenhuma referência a clínica, então não tem como validar se o paciente já fez consulta com a clínica.
    @Override
    public AvaliacaoClinica addAvaliacaoClinica(AvaliarClinicaDto avaliarClinicaDto) {


        AvaliacaoClinica avaliacaoClinica = new AvaliacaoClinica();
        try {
            Clinica clinicaReference = entityManager.getReference(Clinica.class, avaliarClinicaDto.clinicaCnpj());
            Paciente pacienteReference = entityManager.getReference(Paciente.class, avaliarClinicaDto.pacienteCpf());
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
