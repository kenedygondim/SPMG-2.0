package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Paciente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PacienteReactiveCrudRepository extends ReactiveCrudRepository<Paciente, String> {
}
