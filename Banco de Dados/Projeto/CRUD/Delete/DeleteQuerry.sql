CREATE DATABASE teste;

USE teste;

GO
if exists (select * from sysdatabases where name='projeto_mecanica')
drop database projeto_mecanica
go

DELETE FROM Carro WHERE cod_carro > 10;

DELETE FROM Carro;
DELETE FROM Cliente;
DELETE FROM OS;


DELETE FROM servico WHERE cod_servico = 2;