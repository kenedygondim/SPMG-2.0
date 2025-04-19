package com.project.sp_medical_group.Dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliarMedicoDto (
    @NotNull(message = "O identificador do médico é obrigatório")
    Long medicoId,
    @NotNull(message = "O identificador do paciente é obrigatório")
    Long pacienteId,
    @NotBlank(message = "O comentário é obrigatório")
    @Length(min = 1, max = 255, message = "O comentário deve ter entre 1 e 255 caracteres")
    String comentario,
    @NotNull(message = "O número de estrelas é obrigatório")
    @Range(min = 1, max = 5, message = "O número de estrelas deve ser entre 1 e 5")
    Integer numeroEstrelas
) 
{}
