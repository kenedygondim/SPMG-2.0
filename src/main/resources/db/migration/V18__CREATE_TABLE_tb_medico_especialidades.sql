CREATE TABLE tb_medico_especialidades (
      medico_cpf CHAR(11),
      especialidade_id INT,
      valor_procedimento DECIMAL(6,2),
      CONSTRAINT pk_tb_medico_especialidades PRIMARY KEY (medico_cpf, especialidade_id),
      CONSTRAINT fk_tb_medico_especialidades_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
      CONSTRAINT fk_tb_medico_especialidades_tb_especialidades FOREIGN KEY (especialidade_id) REFERENCES tb_especialidades (especialidade_id)
)
