package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CriarEnderecoDto (
        @NotBlank(message = "O CEP é obrigatório")
        @Length(min = 8, max = 8, message = "O CEP deve ter 8 números")
        String cep,
        @NotBlank(message = "A UF é obrigatória")
        @Length(min = 2, max = 2, message = "A UF deve ter 2 caracteres")
        String uf,
        @NotBlank(message = "O município é obrigatório")
        String municipio,
        @NotBlank(message = "O bairro é obrigatório")
        String bairro,
        @NotBlank(message = "O logradouro é obrigatório")
        String logradouro,
        @NotBlank(message = "O número é obrigatório")
        String numero,
        String complemento
){
}
