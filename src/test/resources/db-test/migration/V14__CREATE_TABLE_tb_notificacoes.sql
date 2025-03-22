CREATE TABLE tb_notificacoes (
    notificacao_id INT AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    mensagem VARCHAR(500) NOT NULL,
    is_lida BOOLEAN,
    CONSTRAINT pk_tb_notificacoes PRIMARY KEY (notificacao_id),
    CONSTRAINT fk_tb_notificacoes_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios (usuario_id)
);