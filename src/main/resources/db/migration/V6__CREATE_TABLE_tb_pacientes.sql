CREATE TABLE tb_pacientes (
      cpf CHAR(11),
      usuario_id INT NOT NULL,
      CONSTRAINT pk_tb_pacientes PRIMARY KEY (cpf),
      CONSTRAINT fk_tb_pacientes_tb_pessoas FOREIGN KEY (cpf) REFERENCES tb_pessoas (cpf),
      CONSTRAINT fk_tb_pacientes_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id),
);