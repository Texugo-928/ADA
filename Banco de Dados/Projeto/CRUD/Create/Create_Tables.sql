CREATE DATABASE projeto_mecanica;

USE projeto_mecanica;

GO
if exists (select * from sysdatabases where name='teste')
drop database teste
go

CREATE TABLE Carro(
	cod_carro INT IDENTITY(1,1) NOT NULL,
	modelo VARCHAR(60) NOT NULL,
	placa VARCHAR(8) NOT NULL,
	CONSTRAINT PK_cod_carro PRIMARY KEY (cod_carro)
);

CREATE TABLE Cliente(
	cod_cliente INT IDENTITY(1,1) NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(40) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	endereco VARCHAR(40) NOT NULL,
	complemento_endereco VARCHAR(60) NULL,
	telefone VARCHAR(14) NOT NULL,
	email VARCHAR(20) NOT NULL,
	cep VARCHAR(20) NOT NULL,
	CONSTRAINT PK_cod_cliente PRIMARY KEY (cod_cliente)
);

CREATE TABLE Equipe(
	cod_equipe INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(40),
	CONSTRAINT PK_cod_equipe PRIMARY KEY (cod_equipe)
);

CREATE TABLE Especialidade(
	cod_especialidade INT NOT NULL IDENTITY(1, 1),
	nome VARCHAR(40) NOT NULL,
	CONSTRAINT PK_cod_especialidade PRIMARY KEY (cod_especialidade)
);

CREATE TABLE Peca(
	cod_peca INT IDENTITY(1,1) NOT NULL,
	nome VARCHAR(40) NOT NULL,
	valor_unitario DECIMAL(9,2) NOT NULL,
	CONSTRAINT PK_cod_peca PRIMARY KEY (cod_peca)
);

CREATE TABLE Servico(
	cod_servico INT IDENTITY(1,1) NOT NULL,
	nome VARCHAR(40) NOT NULL,
	mao_de_obra DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_cod_servico PRIMARY KEY (cod_servico)
);

CREATE TABLE OS(
	cod_os INT IDENTITY(1,1) NOT NULL,
	cod_cliente INT NOT NULL,
	cod_carro INT NOT NULL,
	cod_equipe INT NOT NULL,
	situacao CHAR(1) NOT NULL,
	data_emissao DATE NOT NULL,
	data_conclusao DATE NOT NULL,
	valor DECIMAL(9,2) NULL,
	autorizacao CHAR(1) NULL,
	CONSTRAINT PK_cod_os PRIMARY KEY (cod_os),
	CONSTRAINT FK_cod_cliente FOREIGN KEY (cod_cliente) REFERENCES Cliente,
	CONSTRAINT FK_cod_carro FOREIGN KEY (cod_carro) REFERENCES Carro,
	CONSTRAINT FK_cod_equipe FOREIGN KEY (cod_equipe) REFERENCES Equipe
);

CREATE TABLE OS_Servico(
	cod_os_servico INT IDENTITY(1,1) NOT NULL,
	cod_os INT NOT NULL,
	cod_servico INT NOT NULL,
	CONSTRAINT PK_cod_os_servico PRIMARY KEY (cod_os_servico),
	CONSTRAINT FK_cod_os FOREIGN KEY (cod_os) REFERENCES OS,
	CONSTRAINT FK_cod_servico FOREIGN KEY (cod_servico) REFERENCES Servico
);

CREATE TABLE OS_Peca(
	cod_os_peca INT IDENTITY(1,1) NOT NULL,
	cod_os INT NOT NULL,
	cod_peca INT NOT NULL,
	quantidade INT NOT NULL,
	CONSTRAINT PK_cod_os_peca PRIMARY KEY (cod_os_peca),
	CONSTRAINT FK_cod_os_1 FOREIGN KEY (cod_os) REFERENCES OS,
	CONSTRAINT FK_cod_peca FOREIGN KEY (cod_peca) REFERENCES Peca
);

CREATE TABLE Mecanico(
	cod_mecanico INT IDENTITY(1,1) NOT NULL,
	cod_equipe INT NOT NULL,
	nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(40) NOT NULL,
	endereco VARCHAR(40) NOT NULL,
	complemento_endereco VARCHAR(60) NOT NULL,
	cep VARCHAR(10) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	telefone VARCHAR(14) NOT NULL,
	CONSTRAINT PK_cod_mecanico PRIMARY KEY (cod_mecanico),
	CONSTRAINT FK_cod_equipe_1 FOREIGN KEY (cod_equipe) REFERENCES Equipe
);

CREATE TABLE Especialidade_Mecanico(
	cod_especialidade_mecanico INT IDENTITY(1,1) NOT NULL,
	cod_especialidade INT NOT NULL,
	cod_mecanico INT NOT NULL,
	CONSTRAINT PK_cod_especialista_mecanico PRIMARY KEY (cod_especialidade_mecanico),
	CONSTRAINT FK_cod_equipe_2 FOREIGN KEY (cod_especialidade) REFERENCES Especialidade,
	CONSTRAINT FK_cod_mecanico FOREIGN KEY (cod_mecanico) REFERENCES Mecanico
);