ALTER TABLE tb_consulta_anexos DROP CONSTRAINT pk_tb_consulta_anexos;
ALTER TABLE tb_consulta_anexos ADD CONSTRAINT pk_tb_consulta_anexos PRIMARY KEY (anexo_id);
ALTER TABLE tb_consulta_anexos ADD anexo_url VARCHAR (255) NOT NULL;