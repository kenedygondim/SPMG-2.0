package com.project.sp_medical_group.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record CriarUsuarioDto (
    @NotBlank(message = "O campo email é obrigatório")
    @Email
    String email,
    @NotBlank(message = "O campo senha é obrigatório")
    String senha
) {
}
