package com.project.sp_medical_group.Dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record CriarMedicoDto(
   @NotBlank(message = "O CRM é obrigatório!")
   @Length(min = 8, max = 8, message = "O CRM deve ter 8 caracteres!")
    String crm
) {}
