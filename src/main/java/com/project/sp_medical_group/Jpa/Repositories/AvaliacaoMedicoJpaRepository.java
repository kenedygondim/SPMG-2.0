package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.AvaliacaoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AvaliacaoMedicoJpaRepository extends JpaRepository<AvaliacaoMedico, Long> {
    @Query(value = "EXEC PRCDR_checa_consultas_do_paciente_com_o_medico :medico_cpf, :paciente_cpf",
            nativeQuery = true)
    Integer contarConsultas(
            @Param("medico_cpf") String medicoCpf,
            @Param("paciente_cpf") String pacienteCpf);
}
