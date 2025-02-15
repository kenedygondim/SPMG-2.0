CREATE TABLE tb_fotos_perfil (
     foto_perfil_id INT IDENTITY(1,1),
     foto_perfil_url VARCHAR(200),
     CONSTRAINT pk_tb_fotos_perfil PRIMARY KEY (foto_perfil_id)
)