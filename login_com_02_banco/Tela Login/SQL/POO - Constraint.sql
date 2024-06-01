-- Chave primaria da tabela alunos
ALTER TABLE Alunos
	ADD CONSTRAINT PK_Alunos
		PRIMARY KEY (RA);

-- Chave primaria da tabela usuarios
ALTER TABLE Usuarios
	ADD CONSTRAINT PK_Usuarios
		PRIMARY KEY (Login);

-- Checando valor da coluna tipo
ALTER TABLE Usuarios
	ADD CONSTRAINT CK_Usuarios_Tipo
		CHECK (Tipo IN (1, 2));

-- Chave estrangeira Alunos -> Usuarios
ALTER TABLE Usuarios
	ADD CONSTRAINT FK_Usuarios_Alunos
		FOREIGN KEY (Login)
			REFERENCES Alunos (RA);
