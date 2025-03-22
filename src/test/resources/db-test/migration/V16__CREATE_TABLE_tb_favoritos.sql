CREATE TABLE tb_favoritos (
      usuario_id INT,
      usuario_id_favoritado INT,
      CONSTRAINT pk_tb_favoritos PRIMARY KEY(usuario_id, usuario_id_favoritado),
      CONSTRAINT fk_tb_favoritos_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id)
);