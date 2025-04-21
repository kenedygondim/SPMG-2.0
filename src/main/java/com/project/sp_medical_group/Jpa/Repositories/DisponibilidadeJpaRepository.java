package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisponibilidadeJpaRepository extends JpaRepository<Disponibilidade, Long> {
    List<Disponibilidade> findAllByMedicoMedicoIdAndDataDisp(Long medicoId, String dataDisponibilidade);
    @Query("SELECT EXISTS(" +
            "SELECT 1 FROM Disponibilidade d " +
            "WHERE d.dataDisp = ?1 " +
            "AND d.medico.medicoId = ?4 " +
            "AND NOT (" +
            "   d.horaFim <= ?2 OR" +  // Termina antes ou no início do novo
            "   d.horaInicio >= ?3" +  // Começa depois ou no final do novo
            "))")
    Boolean isHorarioOcupado(String dataDisp, String horaInicio, String horaFim, Long medicoId);
}
