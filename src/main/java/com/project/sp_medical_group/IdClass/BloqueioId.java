package com.project.sp_medical_group.IdClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BloqueioId implements Serializable {
    private Long usuario;
    private Long usuarioBloqueado;
}