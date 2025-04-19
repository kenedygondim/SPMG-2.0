package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;
import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.MedicoClinicaJpaRepository;
import com.project.sp_medical_group.Models.*;
import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class MedicoClinicaService implements MedicoClinicaRepository {
    public final MedicoClinicaJpaRepository medicoClinicaJpaRepository;
    private final EntityManager entityManager;

    @Autowired
    public MedicoClinicaService(MedicoClinicaJpaRepository medicoClinicaJpaRepository, EntityManager entityManager) {
        this.medicoClinicaJpaRepository = medicoClinicaJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public MedicoClinica associateMedicoClinica(AssociarMedicoClinicaDto associarMedicoClinicaDto) {
        try {
            //TO-DO: melhorar o tratamento de erro
            //TO-DO: melhorar o INSERT pois este está fazendo um SELECT gigantesco antes de fazer o INSERT

            System.out.println("Associando médico e especialidade: " + associarMedicoClinicaDto);

            MedicoClinica medicoClinica = new MedicoClinica();
            medicoClinica.setMedico(entityManager.getReference(Medico.class, associarMedicoClinicaDto.medicoId()));
            medicoClinica.setClinica(entityManager.getReference(Clinica.class, associarMedicoClinicaDto.clinicaId()));

            System.out.println("Medico-Clinica: " + medicoClinica);

            return medicoClinicaJpaRepository.save(medicoClinica);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Tentativa de quebra de CONSTRAINT: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new BusinessException("Médico ou clínica não encontrados: " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao associar médico e clínica: " + e.getMessage());
        }
    }
}
