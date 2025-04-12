package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.AvaliacaoClinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoClinicaJpaRepository extends JpaRepository<AvaliacaoClinica, Long> {
    List<AvaliacaoClinica> findByClinicaCnpj(String clinicaCnpj);
}
