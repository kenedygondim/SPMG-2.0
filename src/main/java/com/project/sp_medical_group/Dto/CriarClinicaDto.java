package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CriarClinicaDto (
    @NotBlank(message = "O CNPJ é obrigatório")
    @Length(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres")
    String cnpj,
    @NotBlank(message = "O nome fantasia é obrigatório")
    String nomeFantasia,
    @NotBlank(message = "A razão social é obrigatória")
    String razaoSocial
) { }
