package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeJpaRepository extends JpaRepository<Disponibilidade, Integer> {
    // Custom query methods can be defined here if needed
}
