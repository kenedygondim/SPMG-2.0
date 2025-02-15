CREATE TABLE tb_avaliacoes_medico (
      avaliacao_id INT IDENTITY(1,1),
      medico_cpf CHAR(11) NOT NULL,
      paciente_cpf CHAR(11) NOT NULL,
      numero_estrelas INT NOT NULL,
      comentario VARCHAR (255) NOT NULL
      CONSTRAINT pk_tb_avaliacoes_medico PRIMARY KEY (avaliacao_id),
      CONSTRAINT fk_tb_avaliacoes_medico_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
      CONSTRAINT fk_tb_avaliacoes_medico_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf)
);