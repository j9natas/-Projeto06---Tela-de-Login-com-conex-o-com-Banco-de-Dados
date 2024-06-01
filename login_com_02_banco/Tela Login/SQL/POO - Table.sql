-- Criando tabela alunos
CREATE TABLE Alunos (
	RA    CHAR(8)      NOT NULL,
	Nome  VARCHAR(255) NOT NULL,
	Email VARCHAR(255) NOT NULL
);

-- Criando tabela usuários
CREATE TABLE Usuarios (
	Login    CHAR(8)      NOT NULL,
	Senha    VARCHAR(255) NOT NULL,
	Tipo     INT          NOT NULL DEFAULT 1
);
