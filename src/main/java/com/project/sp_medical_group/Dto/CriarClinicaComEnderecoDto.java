package com.project.sp_medical_group.Dto;

import jakarta.validation.Valid;

public record CriarClinicaComEnderecoDto(
         @Valid CriarClinicaDto clinica,
         @Valid CriarEnderecoDto endereco
) { }

