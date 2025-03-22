CREATE TABLE tb_avaliacoes_medico (
      avaliacao_id INT AUTO_INCREMENT,
      medico_cpf CHAR(11) NOT NULL,
      paciente_cpf CHAR(11) NOT NULL,
      numero_estrelas INT NOT NULL,
      comentario VARCHAR(255) NOT NULL,
      PRIMARY KEY (avaliacao_id),
      FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
      FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf)
);