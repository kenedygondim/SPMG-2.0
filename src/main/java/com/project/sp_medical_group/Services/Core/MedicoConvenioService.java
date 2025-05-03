package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;
import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.MedicoConvenioJpaRepository;
import com.project.sp_medical_group.Models.*;
import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;
import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MedicoConvenioService implements MedicoConvenioRepository {
    private final MedicoConvenioJpaRepository medicoConvenioJpaRepository;
    private final EntityManager entityManager;

    @Autowired
    public MedicoConvenioService(MedicoConvenioJpaRepository medicoConvenioJpaRepository,
                                 EntityManager entityManager) {
        this.medicoConvenioJpaRepository = medicoConvenioJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public MedicoConvenio associateMedicoConvenio(AssociarMedicoConvenioDto associarMedicoConvenioDto) {
        try {
            //TO-DO: melhorar o tratamento de erro
            //TO-DO: melhorar o INSERT pois este está fazendo um SELECT gigantesco antes de fazer o INSERT

            System.out.println("Associando médico e convênio: " + associarMedicoConvenioDto);

            MedicoConvenio medicoConvenio = new MedicoConvenio();
            medicoConvenio.setMedico(entityManager.getReference(Medico.class, associarMedicoConvenioDto.medicoId()));
            medicoConvenio.setConvenio(entityManager.getReference(Convenio.class, associarMedicoConvenioDto.convenioId()));

            System.out.println("Medico-Convenio: " + medicoConvenio);

            return medicoConvenioJpaRepository.save(medicoConvenio);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Tentativa de quebra de CONSTRAINT: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new BusinessException("Médico ou convenio não encontrados: " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao associar médico e convenio: " + e.getMessage());
        }
    }
}
