CREATE DATABASE exercicio_2;

USE exercicio_2;

-- CLIENTE(cod_cliente, nome, sobrenome, endereco, complemento_endereco, telefone, email)
CREATE TABLE cliente(
	cod_cliente INTEGER IDENTITY(1,1) NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(40) NOT NULL,
	endereco VARCHAR(40) NULL,
	complemento_endereco VARCHAR(60) NULL,
	telefone VARCHAR(14) NOT NULL,
	email VARCHAR(20) NOT NULL,
	CONSTRAINT PK_cod_cliente PRIMARY KEY (cod_cliente)
);

-- ATENDENTE(cod_atendente, nome, sobrenome, setor, data_admissao, gestor)
CREATE TABLE atendente(
	cod_atendente INTEGER IDENTITY(1,1) NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(40) NOT NULL,
	setor VARCHAR(20) NOT NULL,
	data_admissao DATE NOT NULL,
	gestor VARCHAR(60) NOT NULL,
	CONSTRAINT PK_cod_atendente PRIMARY KEY (cod_atendente)
);

-- ATENDIMENTO(cod_atendimento, cod_cliente, cod_atendente, tipo_ligacao, descricao, data_abertura, data_fechamento, status)
CREATE TABLE atendimento(
	cod_atendimento INTEGER IDENTITY(1,1) NOT NULL,
	cod_cliente INTEGER NOT NULL,
	cod_atendente INTEGER NOT NULL,
	tipo_ligacao VARCHAR(40) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	data_abertura DATE NOT NULL,
	data_fechamento DATE NULL,
	status BIT DEFAULT 0,
	CONSTRAINT PK_cod_atendimento PRIMARY KEY (cod_atendimento),
	CONSTRAINT FK_cod_cliente FOREIGN KEY (cod_cliente)
		REFERENCES cliente (cod_cliente),
	CONSTRAINT FK_cod_atendente FOREIGN KEY (cod_atendente)
		REFERENCES atendente (cod_atendente)
);