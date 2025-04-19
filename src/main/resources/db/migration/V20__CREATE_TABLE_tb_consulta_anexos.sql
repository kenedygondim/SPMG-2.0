CREATE TABLE tb_consulta_anexos (
        anexo_id INT,
        consulta_id INT,
        CONSTRAINT pk_tb_consulta_anexos PRIMARY KEY (anexo_id, consulta_id),
        CONSTRAINT fk_tb_consulta_anexos_tb_consultas FOREIGN KEY (consulta_id) REFERENCES tb_consultas (consulta_id)
);