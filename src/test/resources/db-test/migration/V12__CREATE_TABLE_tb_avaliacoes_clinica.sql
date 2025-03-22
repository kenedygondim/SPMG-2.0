CREATE TABLE tb_avaliacoes_clinica (
       avaliacao_id INT AUTO_INCREMENT,
       clinica_cnpj CHAR(14) NOT NULL,
       paciente_cpf CHAR(11) NOT NULL,
       numero_estrelas INT NOT NULL,
       comentario VARCHAR(255) NOT NULL,
       CONSTRAINT pk_tb_avaliacoes_clinica PRIMARY KEY (avaliacao_id),
       CONSTRAINT fk_tb_avaliacoes_clinica_tb_clinicas FOREIGN KEY (clinica_cnpj) REFERENCES tb_clinicas (cnpj),
       CONSTRAINT fk_tb_avaliacoes_clinica_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf)
);