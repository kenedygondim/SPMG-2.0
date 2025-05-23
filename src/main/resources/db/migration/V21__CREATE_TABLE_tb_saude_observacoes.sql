CREATE TABLE tb_saude_observacoes (
      saude_observacoes_id INT IDENTITY (1,1),
      paciente_id INT NOT NULL,
      alergias VARCHAR (150),
      doencas VARCHAR (150)
      CONSTRAINT pk_saude_observacoes PRIMARY KEY (saude_observacoes_id),
      CONSTRAINT fk_saude_observacoes_tb_pacientes FOREIGN KEY (paciente_id) REFERENCES tb_pacientes (paciente_id)
);