CREATE TABLE tb_disponibilidades (
         disponibilidade_id INT IDENTITY(1,1),
         medico_id INT NOT NULL,
         clinica_Id INT,
         data_disp CHAR(10) NOT NULL,
         hora_inicio CHAR(5) NOT NULL,
         hora_fim CHAR(5) NOT NULL,
         CONSTRAINT pk_tb_disponibilidades PRIMARY KEY (disponibilidade_id),
         CONSTRAINT fk_tb_disponibilidades_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
         CONSTRAINT fk_tb_disponibilidades_tb_clinicas FOREIGN KEY (clinica_id) REFERENCES tb_clinicas (clinica_id)
)