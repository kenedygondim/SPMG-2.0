package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeJpaRepository extends JpaRepository<Especialidade, Integer> {
}
