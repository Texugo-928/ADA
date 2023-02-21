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
CREATE VIEW vw_Especialidades_Mecanicos
AS
SELECT
	mecanico.nome as nome_mecanico,
	especialidade.nome as nome_especialidade
	FROM mecanico
	INNER JOIN especialidade_mecanico
	ON especialidade_mecanico.cod_mecanico = mecanico.cod_mecanico
	INNER JOIN especialidade
	ON especialidade_mecanico.cod_especialidade = especialidade.cod_especialidade;

SELECT * FROM vw_Especialidades_Mecanicos;


