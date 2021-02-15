CREATE TABLE empreendimento(
	id BIGINT(20) PRIMARY KEY auto_increment,
	descricao VARCHAR(40) NOT NULL,
	img VARCHAR(40) NOT NULL
	 
)ENGINE=innodb default charset=utf8;

INSERT INTO empreendimento(descricao,img) values ('Le Jardim','../resources/imagens/le_jardim.jpg');
INSERT INTO empreendimento(descricao,img) values ('Evian','../resources/imagens/evian.jpg');
INSERT INTO empreendimento(descricao,img) values ('Olimpia Thermas','../resources/imagens/olimpia_thermas.jpg');