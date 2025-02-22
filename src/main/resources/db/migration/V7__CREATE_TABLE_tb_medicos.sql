CREATE TABLE tb_medicos (
    cpf CHAR(11),
    crm CHAR(8) NOT NULL UNIQUE,
    usuario_id INT NOT NULL,
    CONSTRAINT pk_tb_medicos PRIMARY KEY (cpf),
    CONSTRAINT fk_tb_medicos_tb_pessoas FOREIGN KEY (cpf) REFERENCES tb_pessoas (cpf),
    CONSTRAINT fk_tb_medicos_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id),
);