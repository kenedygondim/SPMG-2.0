package com.project.sp_medical_group.Models;

//CREATE TABLE tb_anexos (
//        anexo_id INT IDENTITY (1,1),
// consulta_id INT NOT NULL,
//anexo_url VARCHAR (255) NOT NULL,
//CONSTRAINT pk_tb_anexos PRIMARY KEY (anexo_id)
// //CONSTRAINT fk_tb_anexos_tb_consultas FOREIGN KEY (consulta_id) REFERENCES tb_consultas (consulta_id)
//);

import jakarta.persistence.*;

@Entity
@Table(name = "tb_anexos")
public class ConsultaAnexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anexo_id")
    private Long anexoId;

    @Column(name = "anexo_url")
    private String anexoUrl;

    @ManyToOne
    @JoinColumn(name = "consulta_id", referencedColumnName = "consulta_id")
    private Consulta consulta;
}
