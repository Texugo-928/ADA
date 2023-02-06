CREATE DATABASE exercicio_1;
USE exercicio_1;

--Professor (cod_prof, nome, endereco, cep, cidade, uf);
CREATE TABLE professor (
	cod_prof INT NOT NULL IDENTITY(1,1),
	nome VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NULL,
	cep VARCHAR(10) NULL,
	cidade VARCHAR(40) NULL,
	uf CHAR(2) NULL,
	CONSTRAINT PK_cod_prof PRIMARY KEY (cod_prof)
);

--Aluno (cod_alun, nome, endereco, cep, cidade, uf);
CREATE TABLE aluno (
	cod_alun INT NOT NULL IDENTITY(1,1),
	nome VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NULL,
	cep VARCHAR(10) NULL,
	cidade VARCHAR(40) NULL,
	uf CHAR(2) NULL,
	CONSTRAINT PK_cod_alun PRIMARY KEY (cod_alun)
);

--Disciplina (cod_disc, nome, curso, qtd_aulas);
CREATE TABLE disciplina (
	cod_disc INT NOT NULL IDENTITY(1,1),
	nome VARCHAR(100) NOT NULL,
	curso VARCHAR(50) NOT NULL,
	qtd_aulas INT NOT NULL
	CONSTRAINT PK_cod_disc PRIMARY KEY (cod_disc)
);

--Matrícula (cod_matri, cod_aluno, cod_disc, ano);
CREATE TABLE matricula (
	cod_matri INT NOT NULL IDENTITY(1,1),
	cod_aluno INT NOT NULL,
	cod_disc INT NOT NULL,
	ano INT NULL,
	CONSTRAINT PK_cod_matri PRIMARY KEY (cod_matri),
	CONSTRAINT FK_cod_aluno FOREIGN KEY (cod_aluno)
		REFERENCES aluno (cod_alun),
	CONSTRAINT FK_cod_disc FOREIGN KEY (cod_disc)
		REFERENCES disciplina (cod_disc)
);

--Professor_Disciplina(cod_prof_disc, cod_disc, cod_prof, ano);
CREATE TABLE professor_disciplina (
	cod_prof_disc INT NOT NULL IDENTITY(1,1),
	cod_disci INT NOT NULL,
	cod_profo INT NOT NULL,
	ano INT NULL,
	CONSTRAINT PK_cod_prof_disc PRIMARY KEY (cod_prof_disc),
	CONSTRAINT FK_cod_disci FOREIGN KEY (cod_disci)
		REFERENCES disciplina (cod_disc),
	CONSTRAINT FK_cod_profo FOREIGN KEY (cod_profo)
		REFERENCES professor (cod_prof)
);