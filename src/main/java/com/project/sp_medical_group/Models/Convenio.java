package com.project.sp_medical_group.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tb_convenios")
@Getter
@NoArgsConstructor
public class Convenio {
    public Convenio (String convenioNome) {
        this.convenioNome = convenioNome;
    }

    @Id
    @Column("convenio_id")
    private int convenioId;

    @Column("convenio_nome")
    @Setter
    private String convenioNome;
}
