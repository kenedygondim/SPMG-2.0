CREATE TABLE tb_disponibilidades (
    disponibilidade_id INT AUTO_INCREMENT,
    medico_cpf CHAR(11) NOT NULL,
    data_disp CHAR(10) NOT NULL,
    hora_inicio CHAR(5) NOT NULL,
    hora_fim CHAR(5) NOT NULL,
    CONSTRAINT pk_tb_disponibilidades PRIMARY KEY (disponibilidade_id),
    CONSTRAINT fk_tb_disponibilidades_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf)
);