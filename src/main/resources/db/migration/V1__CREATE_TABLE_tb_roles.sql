CREATE TABLE tb_roles (
      role_id INT IDENTITY(1,1),
      role_nome VARCHAR(20) NOT NULL UNIQUE,
      CONSTRAINT pk_tb_roles PRIMARY KEY (role_id)
)