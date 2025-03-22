CREATE TABLE tb_consulta_anexos (
        anexo_id INT,
        consulta_id INT,
        PRIMARY KEY (anexo_id, consulta_id),
        FOREIGN KEY (consulta_id) REFERENCES tb_consultas (consulta_id)
);