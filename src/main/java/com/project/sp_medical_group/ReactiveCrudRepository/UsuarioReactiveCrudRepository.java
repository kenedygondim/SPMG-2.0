package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioReactiveCrudRepository extends ReactiveCrudRepository<Usuario, Integer> { }
