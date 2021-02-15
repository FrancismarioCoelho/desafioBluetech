CREATE TABLE eleicao(
	id BIGINT(20) PRIMARY KEY auto_increment,
	empreendimento_id  BIGINT(40) NOT NULL,
	usuario_id BIGINT(40) NOT NULL,
	CONSTRAINT fk_empreendimento FOREIGN KEY (empreendimento_id) REFERENCES empreendimento (id),
	CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
	 
)ENGINE=innodb default charset=utf8;