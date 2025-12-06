CREATE DATABASE Prova2;
GO

USE Prova2;
GO

CREATE TABLE Paciente (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    peso FLOAT,
    altura FLOAT
);