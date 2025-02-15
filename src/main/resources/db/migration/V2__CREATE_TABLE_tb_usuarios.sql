CREATE TABLE tb_usuarios (
     usuario_id INT IDENTITY(1,1),
     role_id INT NOT NULL,
     email VARCHAR(60) NOT NULL UNIQUE,
     senha VARCHAR (200) NOT NULL,
     CONSTRAINT pk_tb_usuarios PRIMARY KEY (usuario_id),
     CONSTRAINT fk_tb_usuarios_tb_roles FOREIGN KEY (role_id) REFERENCES tb_roles (role_id)
)