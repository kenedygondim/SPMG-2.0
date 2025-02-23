package com.project.sp_medical_group.ReactiveCrudRepository;

import com.project.sp_medical_group.Models.Pessoa;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PessoaReactiveCrudRepository extends ReactiveCrudRepository<Pessoa, String> { }
