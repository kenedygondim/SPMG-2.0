CREATE TABLE tb_medico_convenios (
     convenio_id INT,
     medico_cpf CHAR(11),
     PRIMARY KEY (convenio_id, medico_cpf),
     FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
     FOREIGN KEY (convenio_id) REFERENCES tb_convenios (convenio_id)
);