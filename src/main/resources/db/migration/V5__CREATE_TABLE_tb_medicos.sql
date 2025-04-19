CREATE TABLE tb_medicos (
    medico_id INT IDENTITY(1,1),
    crm CHAR(8) NOT NULL UNIQUE,
    pessoa_id INT NOT NULL,
    usuario_id INT NOT NULL,
    CONSTRAINT pk_tb_medicos PRIMARY KEY (medico_id),
    CONSTRAINT fk_tb_medicos_tb_pessoas FOREIGN KEY (pessoa_id) REFERENCES tb_pessoas (pessoa_id),
    CONSTRAINT fk_tb_medicos_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id),
);