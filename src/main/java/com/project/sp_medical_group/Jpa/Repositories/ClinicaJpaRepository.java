package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaJpaRepository extends JpaRepository<Clinica, Long> {
    Clinica findByClinicaId(Long clinicaId);
    Clinica findByCnpj(String cnpj);
    Clinica findByNomeFantasia(String nomeFantasia);
    Clinica findByRazaoSocial(String razaoSocial);
}
