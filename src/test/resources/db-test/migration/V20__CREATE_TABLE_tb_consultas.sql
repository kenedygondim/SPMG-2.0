CREATE TABLE tb_consultas (
      consulta_id INT AUTO_INCREMENT,
      disponibilidade_id INT NOT NULL,
      especialidade_id INT NOT NULL,
      descricao VARCHAR(150) NOT NULL,
      situacao VARCHAR(20) NOT NULL,
      paciente_cpf CHAR(11) NOT NULL,
      is_telemedicina BOOLEAN NOT NULL,
      CONSTRAINT pk_tb_consultas PRIMARY KEY (consulta_id),
      CONSTRAINT fk_tb_consultas_tb_disponibilidades FOREIGN KEY (disponibilidade_id) REFERENCES tb_disponibilidades (disponibilidade_id),
      CONSTRAINT fk_tb_consultas_tb_pacientes FOREIGN KEY (paciente_cpf) REFERENCES tb_pacientes (cpf),
      CONSTRAINT fk_tb_consultas_tb_especialidades FOREIGN KEY (especialidade_id) REFERENCES tb_especialidades (especialidade_id)
);
