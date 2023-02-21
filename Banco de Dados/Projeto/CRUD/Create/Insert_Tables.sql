USE projeto_mecanica;

--Carro(cod_carro, modelo, placa)
INSERT INTO Carro VALUES
	('Fiesta', 'AXR-7123'),
	('Fusca', 'AZD-76F5'),
	('HB20', 'ASX-7654'),
	('Sonata', 'BTX-4785'),
	('Argo', 'BMW-5467')

--Cliente(cod_cliente, nome, sobrenome, cpf, endereco, complemento_endereco, telefone, email, cep)
INSERT INTO Cliente VALUES
	('Texugo', 'Adriel de Cacio', 02156723460, 'R teste', 'apt 00', 32068482, 'asdasda@as.com', 82600000),
	('Alessandro', 'Ariane de Souza', 98324626238, 'R teste 2', 'casa 2', 32067584, 'sudgvaaj@ask.com.br', 82300990),
	('Vinicius', 'Silva', 96347538398, 'R teste 3', '', 32063484, 'sudssdfj@sk.com.br', 82345990)

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
	('Tansistor', 35.00),
	('Para-lama', 65.00),
	('Pneu', 250.00),
	('Lâmpada', 25.00)

--Servico(cod_servico, nome, mao_de_obra)
INSERT INTO Servico VALUES
	('Revisão', 100.00),
	('Toca de Óleo', 40.00)

--Mecanico(cod_mecanico, cod_equipe, nome, sobrenome, endereco, complemento_endereco, cep, cpf, telefone)
INSERT INTO Mecanico VALUES
	(1, 'Aldemir', 'Jose da Silva', 'R Teste', 'apt 00', 82600000, 02145289760, 32068485),
	(1, 'Dennis', 'Alcantara', 'R Teste 2', 'apt 01', 82610230, 12376589760, 32457885),
	(2, 'Osvaldo', 'Coelho', 'R Teste 3', 'apt 02', 82620450, 29337526760, 32983285),
	(2, 'Josué', 'Afrânio', 'R Teste 4', 'apt 03', 82630780, 09543857976, 32217685)

--Especialidade_Mecanico(cod_especialidade_mecanico, cod_especialidade, cod_mecanico)
INSERT INTO Especialidade_Mecanico VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(1, 2),
	(5, 2),
	(2, 3),
	(4, 4)

--OS(cod_os, cod_cliente, cod_carro, cod_equipe, situacao, data_emissao, data_conclusao, valor(N), autorizacao(N))
INSERT INTO OS VALUES
	(1, 1, 1, 'A', '25-02-2023', '26-02-2023', 250.00, 'C'),
	(1, 2, 1, 'A', '20-02-2004', '21-04-2004', 240.00, 'C'),
	(1, 2, 2, 'A', '25-03-2023', '26-05-2023', 170.00, 'C')

	--Após o Update


--OS_Peca(cod_os_peca, cod_os, cod_peca, quantidade)
INSERT INTO OS_Peca VALUES
	(1, 1, 12),
	(2, 1, 13),
	(3, 2, 2),
	(3, 4, 4),
	(3, 5, 2)

--OS_Servico(cod_os_servico, cod_os, cod_servico)
INSERT INTO OS_Servico VALUES
	(1, 1),
	(2, 1),
	(2, 2),
	(3, 2)