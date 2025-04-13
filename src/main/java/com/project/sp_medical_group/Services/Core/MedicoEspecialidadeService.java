package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AssociarMedicoEspecialidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.MedicoEspecialidadeJpaRepository;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Models.Medico;
import com.project.sp_medical_group.Models.MedicoEspecialidade;
import com.project.sp_medical_group.Repositories.MedicoEspecialidadeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoEspecialidadeService implements MedicoEspecialidadeRepository {
    private final MedicoEspecialidadeJpaRepository medicoEspecialidadeJpaRepository;
    private final EntityManager entityManager;

    @Autowired
    public MedicoEspecialidadeService(MedicoEspecialidadeJpaRepository medicoEspecialidadeJpaRepository,
                                      EntityManager entityManager)
    {
        this.medicoEspecialidadeJpaRepository = medicoEspecialidadeJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public MedicoEspecialidade associateMedicoEspecialidade(AssociarMedicoEspecialidadeDto associarMedicoEspecialidadeDto) {
        try {
            //TO-DO: melhorar o tratamento de erro
            //TO-DO: melhorar o INSERT pois este está fazendo um SELECT gigantesco antes de fazer o INSERT

            System.out.println("Associando médico e especialidade: " + associarMedicoEspecialidadeDto);

            MedicoEspecialidade medicoEspecialidade = new MedicoEspecialidade();
            medicoEspecialidade.setMedico(entityManager.getReference(Medico.class, associarMedicoEspecialidadeDto.medicoCpf()));
            medicoEspecialidade.setEspecialidade(entityManager.getReference(Especialidade.class, associarMedicoEspecialidadeDto.especialidadeId()));
            medicoEspecialidade.setValorProcedimento(associarMedicoEspecialidadeDto.valorProcedimento());

            System.out.println("Medico-Especialidade: " + medicoEspecialidade);

            return medicoEspecialidadeJpaRepository.save(medicoEspecialidade);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Tentativa de quebra de CONSTRAINT: " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao associar médico e especialidade: " + e.getMessage());
        }
    }

    @Override
    public List<MedicoEspecialidade> getAllMedicoEspecialidadesByMedicoCpf(String medicoCpf) {
        return medicoEspecialidadeJpaRepository.findByMedicoCpf(medicoCpf);
    }
}
