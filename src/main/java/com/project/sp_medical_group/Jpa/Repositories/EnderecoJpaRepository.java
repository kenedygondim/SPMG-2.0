package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoJpaRepository extends JpaRepository<Endereco, Long> { }
