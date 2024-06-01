-- Inserindo usuário administrador
INSERT INTO
	Alunos
		(RA, Nome, Email)
	VALUES
		('Admin', 'Admin', 'admin@admin');

-- Inserindo login e senha do administrador
INSERT INTO
	Usuarios
		(Login, Senha, Tipo)
	VALUES
		('Admin', 'adminpassword', 2);

-- Inserindo novo aluno
INSERT INTO
	Alunos
		(RA, Nome, Email)
	VALUES
		('N036JF8', 'Lucas Braga Silva', 'llucasbsilva@gmail.com');

-- Inserindo login e senha do novo aluno
INSERT INTO
	Usuarios
		(Login, Senha)
	VALUES
		('N036JF8', '1702casa2071');
