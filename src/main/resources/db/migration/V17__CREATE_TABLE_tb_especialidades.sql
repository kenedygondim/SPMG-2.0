CREATE TABLE tb_especialidades (
       especialidade_id INT IDENTITY(1,1),
       nome VARCHAR (80) UNIQUE,
       descricao VARCHAR (150),
       CONSTRAINT pk_tb_especialidades PRIMARY KEY (especialidade_id)
)