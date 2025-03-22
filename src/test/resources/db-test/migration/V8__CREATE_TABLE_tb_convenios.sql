CREATE TABLE tb_convenios (
      convenio_id INT AUTO_INCREMENT,
      convenio_nome VARCHAR(100) NOT NULL UNIQUE,
      CONSTRAINT pk_tb_convenios PRIMARY KEY (convenio_id)
);