package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilidadeJpaRepository extends JpaRepository<Disponibilidade, Integer> {
    List<Disponibilidade> findAllByMedicoCpfAndDataDisp(String medicoCpf, String dataDisponibilidade);
}
