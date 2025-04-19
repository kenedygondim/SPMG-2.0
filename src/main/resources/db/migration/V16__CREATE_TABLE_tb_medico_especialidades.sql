CREATE TABLE tb_medico_especialidades (
      medico_id INT NOT NULL,
      especialidade_id INT NOT NULL,
      valor_procedimento DECIMAL(6,2),
      CONSTRAINT pk_tb_medico_especialidades PRIMARY KEY (medico_id, especialidade_id),
      CONSTRAINT fk_tb_medico_especialidades_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
      CONSTRAINT fk_tb_medico_especialidades_tb_especialidades FOREIGN KEY (especialidade_id) REFERENCES tb_especialidades (especialidade_id)
)
