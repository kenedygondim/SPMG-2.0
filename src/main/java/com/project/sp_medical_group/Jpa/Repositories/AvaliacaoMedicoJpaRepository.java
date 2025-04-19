package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.AvaliacaoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AvaliacaoMedicoJpaRepository extends JpaRepository<AvaliacaoMedico, Long> {
    @Query(value = "EXEC PRCDR_checa_consultas_do_paciente_com_o_medico :medico_id, :paciente_id",
            nativeQuery = true)
    Integer contarConsultas(
            @Param("medico_id") Long medicoId, // Alterar na Procedure
            @Param("paciente_id") Long pacienteId); // Alterar na Procedure
    Optional<AvaliacaoMedico> findByMedicoMedicoIdAndPacientePacienteId(Long medicoId, Long pacienteId);
}
