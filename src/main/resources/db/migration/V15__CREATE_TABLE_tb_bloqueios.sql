CREATE TABLE tb_bloqueios (
      usuario_id INT,
      usuario_id_bloqueado INT,
      CONSTRAINT pk_tb_bloqueios PRIMARY KEY(usuario_id, usuario_id_bloqueado),
      CONSTRAINT fk_tb_bloqueios_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id)
);