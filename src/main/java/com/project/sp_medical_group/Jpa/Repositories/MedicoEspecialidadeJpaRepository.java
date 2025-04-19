package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.IdClass.MedicoEspecialidadeId;
import com.project.sp_medical_group.Models.MedicoEspecialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoEspecialidadeJpaRepository extends JpaRepository<MedicoEspecialidade, MedicoEspecialidadeId>
{
    List<MedicoEspecialidade> findByMedicoMedicoId(Long medicoId);
}
