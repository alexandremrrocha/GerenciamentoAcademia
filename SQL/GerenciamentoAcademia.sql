--CREATE DATABASE Prova3Academia;

CREATE TABLE Cliente (
	nome varchar(50) not null,
	cpf varchar(50) not null,
	endereco varchar(50) not null,
	bairro varchar(50) not null,
	cidade varchar(50) not null,
	uf varchar(50) not null,
	telefone varchar(50) not null,
	restricao varchar(50) not null
);

CREATE TABLE Equipamento (
	codigo varchar(50) not null,
	nome varchar(50) not null,
	fornecedor varchar(50) not null,
	dataCompra date not null,
	quantidade varchar(50) not null,
	valor varchar(50) not null,
	limitePeso varchar(50) not null
);

CREATE TABLE Funcionario (
	nome varchar(50) not null,
	cpf varchar(50) not null,
	endereco varchar(50) not null,
	cidade varchar(50) not null,
	uf varchar(50) not null,
	cargo varchar(50) not null,
	dataContratacao date not null,
	salario varchar(50) not null
);

CREATE TABLE Treino (
	nomeCliente varchar(50) not null,
	numeroTreino varchar(50) not null,
	nomePersonal varchar(50) not null,
	dataTreino date not null,
	preTreino varchar(50) not null,
	tempoPre varchar(50) not null,
	posTreino varchar(50) not null,
	tempoPos varchar(50) not null,
	grupoMuscular varchar(50) not null,
	serie varchar(50) not null,
	repeticao varchar(50) not null,
	intervalo varchar(50) not null,
	horaInicio varchar(50) not null,
	horaFim varchar(50) not null
);

