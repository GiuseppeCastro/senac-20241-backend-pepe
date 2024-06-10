DROP DATABASE IF EXISTS exemplos;
CREATE DATABASE exemplos;
USE exemplos; 

CREATE TABLE Montadora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    paisFundacao VARCHAR(100) NOT NULL,
    nomePresidente VARCHAR(100) NOT NULL,
    dataFundacao DATE NOT NULL
);

CREATE TABLE Carro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(20) NOT NULL,
    montadora_id INT NOT NULL,
    ano INT NOT NULL,
    valor DOUBLE NOT NULL,
    FOREIGN KEY (montadora_id) REFERENCES Montadora(id)
);

-- Inserts das montadoras
INSERT INTO Montadora (nome, paisFundacao, nomePresidente, dataFundacao) VALUES ('Toyota', 'Japão', 'João Silva', '2012-03-12');
INSERT INTO Montadora (nome, paisFundacao, nomePresidente, dataFundacao) VALUES ('Ford', 'Estados Unidos', 'Maria Santos' , '2018-03-12');
INSERT INTO Montadora (nome, paisFundacao, nomePresidente, dataFundacao) VALUES ('Volkswagen', 'Alemanha', 'José Oliveira', '2017-03-12');
INSERT INTO Montadora (nome, paisFundacao, nomePresidente, dataFundacao) VALUES ('GM', 'Estados Unidos', 'Ana Pereira', '2016-03-12');
INSERT INTO Montadora (nome, paisFundacao, nomePresidente, dataFundacao) VALUES ('Honda', 'Japão', 'Pedro Almeida', '2015-03-12');
INSERT INTO Montadora (nome, paisFundacao, nomePresidente, dataFundacao) VALUES ('Nissan', 'Japão', 'Mariana Costa', '2013-03-12');

-- Inserts dos carros
INSERT INTO Carro (modelo, placa, montadora_id, ano, valor) VALUES ('Gol', 'ABC1234', 1, 2020, 45000.00);
INSERT INTO Carro (modelo, placa, montadora_id, ano, valor) VALUES ('Onix', 'DEF5678', 4, 2021, 50000.00);
INSERT INTO Carro (modelo, placa, montadora_id, ano, valor) VALUES ('Corolla', 'GHI9012', 2, 2019, 80000.00);
INSERT INTO Carro (modelo, placa, montadora_id, ano, valor) VALUES ('Civic', 'JKL3456', 5, 2022, 75000.00);
INSERT INTO Carro (modelo, placa, montadora_id, ano, valor) VALUES ('Uno', 'MNO7890', 3, 2018, 30000.00);