CREATE TABLE tb_medico_clinicas (
    medico_cpf CHAR(11),
    clinica_cnpj CHAR(14),
    CONSTRAINT pk_tb_medico_clinicas PRIMARY KEY (medico_cpf, clinica_cnpj),
    CONSTRAINT fk_tb_medico_clinicas_tb_medicos FOREIGN KEY (medico_cpf) REFERENCES tb_medicos (cpf),
    CONSTRAINT fk_tb_medico_clinicas_tb_clinicas FOREIGN KEY (clinica_cnpj) REFERENCES tb_clinicas (cnpj)
);