package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.AvaliacaoClinica;
import com.project.sp_medical_group.Models.AvaliacaoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoClinicaJpaRepository extends JpaRepository<AvaliacaoClinica, Long> {
    @Query(value = "EXEC PRCDR_checa_consultas_do_paciente_na_clinica :clinica_id, :paciente_id",
            nativeQuery = true)
    Integer contarConsultas(
            @Param("clinica_id") Long clinicaId,
            @Param("paciente_id") Long pacienteId);
    Optional<AvaliacaoClinica> findByClinicaClinicaIdAndPacientePacienteId(Long clinicaId, Long pacienteId);
    List<AvaliacaoClinica> findByClinicaClinicaId(Long clinicaId);
}

