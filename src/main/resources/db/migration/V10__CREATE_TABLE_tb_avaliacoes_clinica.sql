CREATE TABLE tb_avaliacoes_clinica (
       avaliacao_id INT IDENTITY(1,1),
       clinica_id INT NOT NULL,
       paciente_id INT NOT NULL,
       numero_estrelas INT NOT NULL,
       comentario VARCHAR (255) NOT NULL
       CONSTRAINT pk_tb_avaliacoes_clinica PRIMARY KEY (avaliacao_id),
       CONSTRAINT fk_tb_avaliacoes_clinica_tb_clinicas FOREIGN KEY (clinica_id) REFERENCES tb_clinicas (clinica_id),
       CONSTRAINT fk_tb_avaliacoes_clinica_tb_pacientes FOREIGN KEY (paciente_id) REFERENCES tb_pacientes (paciente_id)
);