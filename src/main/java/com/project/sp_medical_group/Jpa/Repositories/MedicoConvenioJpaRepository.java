package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.IdClass.MedicoConvenioId;
import com.project.sp_medical_group.Models.MedicoConvenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoConvenioJpaRepository extends JpaRepository<MedicoConvenio, MedicoConvenioId> {
    // Métodos adicionais, se necessário
    // Exemplo: List<MedicoConvenio> findByMedicoId(Long medicoId);
}
