CREATE TABLE tb_enderecos (
      endereco_id INT IDENTITY(1,1),
      cep CHAR(8) NOT NULL,
      uf CHAR(2) NOT NULL,
      municipio VARCHAR(35) NOT NULL,
      bairro VARCHAR(105) NOT NULL,
      logradouro VARCHAR(105) NOT NULL,
      numero VARCHAR (10) NOT NULL,
      complemento VARCHAR(200),
      CONSTRAINT pk_tb_enderecos PRIMARY KEY (endereco_id)
)