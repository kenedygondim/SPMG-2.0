CREATE TABLE tb_medico_convenios (
     convenio_id INT NOT NULL,
     medico_id INT NOT NULL,
     CONSTRAINT pk_tb_medico_convenios PRIMARY KEY (convenio_id, medico_id),
     CONSTRAINT fk_tb_medico_convenios_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
     CONSTRAINT fk_tb_medico_convenios_tb_convenios FOREIGN KEY (convenio_id) REFERENCES tb_convenios (convenio_id)
);