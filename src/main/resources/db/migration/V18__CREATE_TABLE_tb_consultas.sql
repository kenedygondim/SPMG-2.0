CREATE TABLE tb_consultas (
      consulta_id INT IDENTITY(1,1),
      disponibilidade_id INT NOT NULL,
      especialidade_id INT NOT NULL,
      descricao VARCHAR(150) NOT NULL,
      situacao VARCHAR (20) NOT NULL,
      paciente_id INT NOT NULL,
      is_telemedicina BIT NOT NULL,
      CONSTRAINT pk_tb_consultas PRIMARY KEY (consulta_id),
      CONSTRAINT fk_tb_consultas_tb_disponibilidades FOREIGN KEY (disponibilidade_id) REFERENCES tb_disponibilidades (disponibilidade_id),
      CONSTRAINT fk_tb_consultas_tb_pacientes FOREIGN KEY (paciente_id) REFERENCES tb_pacientes (paciente_id),
      CONSTRAINT fk_tb_consultas_tb_especialidades FOREIGN KEY (especialidade_id) REFERENCES tb_especialidades (especialidade_id)
)