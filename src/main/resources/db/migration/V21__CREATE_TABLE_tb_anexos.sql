CREATE TABLE tb_anexos (
       anexo_id INT IDENTITY (1,1),
       anexo_url VARCHAR (255) NOT NULL,
       CONSTRAINT pk_tb_anexos PRIMARY KEY (anexo_id)
);