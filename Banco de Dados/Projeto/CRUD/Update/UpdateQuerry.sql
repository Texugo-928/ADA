USE projeto_mecanica;

--Atualizando uma linha espec�fica de uma tabela
UPDATE Especialidade SET nome='C�mbio' WHERE cod_especialidade = 3;
UPDATE OS SET situacao='Em Andamento' WHERE situacao='A';

--Trocando os comandos abaixo por um if-else
UPDATE OS SET autorizacao='S' WHERE data_conclusao <= '01-01-2009';
UPDATE OS SET autorizacao='N' WHERE data_conclusao > '01-01-2009';
--Ainda n consegui........

-- Alterando o tipo de entrada de uma coluna espec�fica
ALTER TABLE OS ALTER COLUMN situacao VARCHAR(12) NOT NULL;

