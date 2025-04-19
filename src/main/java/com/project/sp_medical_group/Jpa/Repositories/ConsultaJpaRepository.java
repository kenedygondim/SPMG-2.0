package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaJpaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findAllByPacientePacienteId(Long pacienteId);
}
