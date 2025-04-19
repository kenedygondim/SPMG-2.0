CREATE TABLE tb_convenios (
      convenio_id INT IDENTITY(1,1),
      convenio_nome VARCHAR(100) NOT NULL UNIQUE,
      CONSTRAINT pk_tb_convenios PRIMARY KEY (convenio_id)
);