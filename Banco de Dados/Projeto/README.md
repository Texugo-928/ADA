# Descrição do Projeto


  Esse projeto foca na construção de um banco de dados de um Sistema de Controle e Gerenciamento de Execução de Ordens de Serviço (OS) para uma oficina mecânica,
onde os clientes levam veículos à oficina mecânica para serem consertados ou para passarem por revisões periódicas.

  Cada veículo é designado a uma equipe de mecânicos que identifica os serviços a serem executados,
que preenche uma OS com a data de entrega e que, uma vez autorizado pelo cliente, executa os serviços.

  Uma vez designado o veículo à equipe, é feito um levantamento de todos os serviços necessários e calculado o valor total da mão-de-obra.
Esse valor é apresentado ao cliente junto com o valor de todas as peças necessárias esperando uma autorzação.
Caso o cliente não autorize a execução do serviços, o mesmo deverá pagar o valor referente a revisões periódicas.
Mas, se o cliente autorizar a execução do serviço, o valor informado na OS será a soma de todos os serviços e peças utilizados.

# Queries SQL usadas:

	* CREATE DATABASE ...
	* DROP DATABASE ...
	* USE ...
	* IF EXISTS ...
	* CREATE TABLE ...
		Utilizando NULL
		Utilizando NOT NULL
		Utilizando CONSTRAINT ... PRIMARY KEY ...
		Utilizando CONSTRAINT ... FOREIGN KEY ... REFERENCES ...
	* INSERT INTO ... VALUES ...
	* UPDATE ... SET [coluna] = [valor a ser trocado]
		Utilizando WHERE ...
	* ALTER TABLE ... ALTER COLUMN ...
	* DELETE FROM ...
		Não Utilizando WHERE ...
		Utilizando WHERE ...
	* DROP VIEW ...
	* SELECT * FROM ...
	* CREATE VIEW ... AS ...
		Utilizando INNER JOIN ... ON ...
		Utilizando LEFT JOIN ... ON ...


###Work In Progress...

