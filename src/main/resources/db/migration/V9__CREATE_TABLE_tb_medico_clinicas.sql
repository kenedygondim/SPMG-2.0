CREATE TABLE tb_medico_clinicas (
    medico_id INT NOT NULL,
    clinica_id INT NOT NULL ,
    CONSTRAINT pk_tb_medico_clinicas PRIMARY KEY (medico_id, clinica_id),
    CONSTRAINT fk_tb_medico_clinicas_tb_medicos FOREIGN KEY (medico_id) REFERENCES tb_medicos (medico_id),
    CONSTRAINT fk_tb_medico_clinicas_tb_clinicas FOREIGN KEY (clinica_id) REFERENCES tb_clinicas (clinica_id)
);