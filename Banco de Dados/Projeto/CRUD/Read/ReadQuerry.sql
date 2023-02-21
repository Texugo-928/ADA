USE projeto_mecanica;

--Visualizando as tabelas:
SELECT * FROM Carro;
SELECT * FROM Cliente;
SELECT * FROM Equipe;
SELECT * FROM Especialidade;
SELECT * FROM Peca;
SELECT * FROM Servico;
SELECT * FROM OS;
SELECT * FROM OS_Servico;
SELECT * FROM OS_Peca;
SELECT * FROM Mecanico;
SELECT * FROM Especialidade_Mecanico;

--View Especialidades por mecânico
CREATE VIEW vw_Especialidade_Mecanico AS
	(SELECT M.nome AS nome_mecanico, E.nome AS nome_especialidade
	FROM Mecanico M INNER JOIN Especialidade_Mecanico EM ON EM.cod_mecanico = M.cod_mecanico
	LEFT JOIN Especialidade E ON EM.cod_especialidade = E.cod_especialidade);

SELECT * FROM vw_Especialidade_Mecanico;


