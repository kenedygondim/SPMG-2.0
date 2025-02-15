CREATE TABLE tb_pessoas (
    cpf CHAR(11),
    nome_completo VARCHAR(150) NOT NULL,
    dt_nascimento VARCHAR(10) NOT NULL,
    rg VARCHAR(9) NOT NULL UNIQUE,
    sexo VARCHAR(30) NOT NULL,
    numero_telefone VARCHAR (20) NOT NULL,
    endereco_id INT NOT NULL,
    CONSTRAINT pk_tb_pessoas PRIMARY KEY (cpf),
    CONSTRAINT fk_tb_pessoas_tb_enderecos FOREIGN KEY (endereco_id) REFERENCES tb_enderecos (endereco_id),
);