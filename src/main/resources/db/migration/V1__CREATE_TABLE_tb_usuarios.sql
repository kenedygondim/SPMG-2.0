CREATE TABLE tb_usuarios (
     usuario_id INT IDENTITY(1,1),
     role_name VARCHAR(50) NOT NULL,
     foto_perfil_url VARCHAR(200),
     email VARCHAR(60) NOT NULL UNIQUE,
     senha VARCHAR (200) NOT NULL,
     CONSTRAINT pk_tb_usuarios PRIMARY KEY (usuario_id),
)