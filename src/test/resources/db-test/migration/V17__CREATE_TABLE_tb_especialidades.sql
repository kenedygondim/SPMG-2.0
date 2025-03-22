CREATE TABLE tb_especialidades (
       especialidade_id INT AUTO_INCREMENT,
       nome VARCHAR(80) UNIQUE,
       descricao VARCHAR(150),
       CONSTRAINT pk_tb_especialidades PRIMARY KEY (especialidade_id)
);