CREATE TABLE tb_roles (
      role_id INT IDENTITY(1,1),
      nome VARCHAR(20) NOT NULL,
      CONSTRAINT pk_tb_roles PRIMARY KEY (role_id)
)