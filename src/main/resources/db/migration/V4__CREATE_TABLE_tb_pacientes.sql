CREATE TABLE tb_pacientes (
      paciente_id INT IDENTITY(1,1),
      pessoa_id  INT NOT NULL,
      usuario_id INT NOT NULL,
      CONSTRAINT pk_tb_pacientes PRIMARY KEY (paciente_id),
      CONSTRAINT fk_tb_pacientes_tb_pessoas FOREIGN KEY (pessoa_id) REFERENCES tb_pessoas (pessoa_id),
      CONSTRAINT fk_tb_pacientes_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id),
);