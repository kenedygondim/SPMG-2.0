package com.project.sp_medical_group.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tb_pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    private String cpf;

    @Column("usuario_id")
    private Integer usuario_id;
}
