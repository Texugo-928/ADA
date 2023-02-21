--Deletando um BD que já está em uso
CREATE DATABASE teste;

USE teste;

BEGIN
IF EXISTS (SELECT * FROM sysdatabases WHERE NAME='projeto_mecanica')
DROP DATABASE projeto_mecanica;
END

--Deletando todas as linhas de uma tabela
DELETE FROM Carro;
DELETE FROM Cliente;
DELETE FROM Equipe;
DELETE FROM Especialidade;
DELETE FROM Peca;
DELETE FROM Servico;
DELETE FROM OS;
DELETE FROM OS_Servico;
DELETE FROM OS_Peca;
DELETE FROM Mecanico;
DELETE FROM Especialidade_Mecanico;

--Deletando linhas de uma tabela usando uma condição específica
DELETE FROM Carro WHERE cod_carro > 10;
DELETE FROM servico WHERE cod_servico = 2;

--Deletando uma View:
DROP VIEW vw_Especialidade_Mecanico;
