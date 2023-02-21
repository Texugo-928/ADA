USE projeto_mecanica;

--Atualizando uma linha específica de uma tabela
UPDATE Especialidade SET nome='Câmbio' WHERE cod_especialidade = 3;
UPDATE OS SET situacao='Em Andamento' WHERE situacao='A';

--Trocando os comandos abaixo por um if-else
UPDATE OS SET autorizacao='S' WHERE data_conclusao <= '01-01-2009';
UPDATE OS SET autorizacao='N' WHERE data_conclusao > '01-01-2009';
--Ainda n consegui........

-- Alterando o tipo de entrada de uma coluna específica
ALTER TABLE OS ALTER COLUMN situacao VARCHAR(12) NOT NULL;

