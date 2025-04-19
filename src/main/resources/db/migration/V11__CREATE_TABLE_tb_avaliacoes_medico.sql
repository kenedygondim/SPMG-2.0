CREATE TABLE tb_avaliacoes_medico (
      avaliacao_id INT IDENTITY(1,1),
      medico_id INT NOT NULL,
      paciente_id INT NOT NULL,
      numero_estrelas INT NOT NULL,
      comentario VARCHAR (255) NOT NULL
      CONSTRAINT pk_tb_avaliacoes_medico PRIMARY KEY (avaliacao_id),
      CONSTRAINT fk_tb_avaliacoes_medico_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
      CONSTRAINT fk_tb_avaliacoes_medico_tb_pacientes FOREIGN KEY (paciente_id) REFERENCES tb_pacientes (paciente_id)
);