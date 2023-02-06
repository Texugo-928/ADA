CREATE DATABASE Exercicio_2;

USE Exercicio_2;

-- Cliente(cod_cliente, nome, sobrenome, endereco, complemento_endereco, telefone, email)
CREATE TABLE Cliente(
	cod_cliente INTEGER IDENTITY(1,1),
	nome VARCHAR(20),
	sobrenome VARCHAR(40),
	endereco VARCHAR(20),
	complemento_endereco VARCHAR(100),
	telefone VARCHAR(14),
	email VARCHAR(20),
	CONSTRAINT PK_cod_cliente PRIMARY KEY (cod_cliente)
);

-- Atendente(cod_atendente, nome, setor, data_admissao, gestor)
CREATE TABLE Atendente(
	cod_atendente INTEGER IDENTITY(1,1),
	nome VARCHAR(20),
	sobrenome VARCHAR(40),
	setor VARCHAR(20),
	data_admissao,
	gestor VARCHAR(100),
	CONSTRAINT PK_cod_atendente PRIMARY KEY (cod_atendente)
);

-- Atendimento(cod_atendimento, cod_cliente, cod_atendente, tipo_ligacao, descricao, data_abertura, data_fechamento, status)
CREATE TABLE Atendimento(
	cod_atendimento INTEGER IDENTITY(1,1),
	cod_cliente INTEGER,
	cod_atendente INTEGER,
	tipo_ligacao,
	descricao,
	data_abertura,
	data_fechamento,
	status,
	CONSTRAINT PK_cod_atendimento PRIMARY KEY (cod_atendimento),
	CONSTRAINT FK_cod_cliente FOREIGN KEY (cod_cliente)
		REFERENCES Cliente (cod_cliente),
	CONSTRAINT FK_cod_atendente FOREIGN KEY (cod_atendente)
		REFERENCES Atendente (cod_atendente)
);