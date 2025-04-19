CREATE TABLE tb_clinicas (
     clinica_id INT IDENTITY(1,1),
     cnpj CHAR(14),
     nome_fantasia VARCHAR(150) NOT NULL UNIQUE,
     razao_social VARCHAR(150) NOT NULL UNIQUE,
     endereco_id INT,
     CONSTRAINT pk_tb_clinicas PRIMARY KEY (clinica_id),
     CONSTRAINT fk_tb_clinicas_tb_enderecos FOREIGN KEY (endereco_id) REFERENCES tb_enderecos (endereco_id)
)