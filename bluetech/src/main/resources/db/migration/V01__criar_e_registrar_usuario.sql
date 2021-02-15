CREATE TABLE usuario(
	id BIGINT(20) PRIMARY KEY auto_increment,
	nome VARCHAR(40) NOT NULL,
	email VARCHAR(40) NOT NULL,
	senha VARCHAR(12) NOT NULL
)ENGINE=innodb default charset=utf8;

INSERT INTO usuario(nome,email,senha) values ('Francismario','francismario.ads@gmail.com','franks');
