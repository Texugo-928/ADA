USE projeto_mecanica;

--Carro(cod_carro, modelo, placa)
INSERT INTO Carro VALUES
	('Fiesta', 'AXR-7123'),
	('Fusca', 'AZD-76F5'),
	('HB20', 'ASX-7654')

--Cliente(cod_cliente, nome, sobrenome, cpf, endereco, complemento_endereco, telefone, email, cep)
INSERT INTO Cliente VALUES
	('Texugo', 'Adriel de Cacio', 02156723460, 'R teste', 'apt 00', 32068482, 'asdasda@as.com', 82600000)

--Equipe(cod_equipe, nome)
INSERT INTO Equipe VALUES
	('Aguia'),
	('Guepardo'),
	('PQD')

--Especialidade(cod_especialidade, nome)
INSERT INTO Especialidade VALUES
	('Injeção Eletrônica'),
	('Suspensão'),
	('Cânbio'),
	('Freio'),
	('Eletrica'),
	('Motor')

--Peca(cod_peca, nome, valor_unitario)
INSERT INTO Peca VALUES
	('Motor de Partida', 750.00),
	('Tansistor', 35.00)

--Servico(cod_servico, nome, mao_de_obra)
INSERT INTO Servico VALUES
	('Revisão', 100.00),
	('Toca de Óleo', 40.00)

--Mecanico(cod_mecanico, cod_equipe, nome, sobrenome, endereco, complemento_endereco, cep, cpf, telefone)
INSERT INTO Mecanico VALUES
	(1, 'Aldemir', 'Jose da Silva', 'R Teste', 'apt 00', 82600000, 02145289760, 32068485)

--Especialidade_Mecanico(cod_especialidade_mecanico, cod_especialidade, cod_mecanico)
INSERT INTO Especialidade_Mecanico VALUES
	(1, 1),
	(2, 1),
	(3, 1)

--OS(cod_os, cod_cliente, cod_carro, cod_equipe, situacao, data_emissao, data_conclusao, valor(N), autorizacao(N))
INSERT INTO OS VALUES
	(1, 1, 1, 'A', '25-02-2023', '26-02-2023', 250.00, 'C'),
	(1, 2, 1, 'A', '20-02-2004', '21-04-2004', 240.00, 'C')

--OS_Peca(cod_os_peca, cod_os, cod_peca, quantidade)
INSERT INTO OS_Peca VALUES
	(1, 1, 12),
	(2, 1, 13)

--OS_Servico(cod_os_servico, cod_os, cod_servico)
INSERT INTO OS_Servico VALUES
	(1, 1),
	(2, 1)