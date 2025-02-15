CREATE TABLE tb_medico_convenios (
     convenio_id INT,
     medico_cpf CHAR(11),
     CONSTRAINT pk_tb_medico_convenios PRIMARY KEY (convenio_id, medico_cpf),
     CONSTRAINT fk_tb_medico_convenios_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
     CONSTRAINT fk_tb_medico_convenios_tb_convenios FOREIGN KEY (convenio_id) REFERENCES tb_convenios (convenio_id)
);