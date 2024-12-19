-- V1__create_table_produtos.sql
CREATE TABLE produto (
                       id SERIAL PRIMARY KEY,
                       nome VARCHAR(100) NOT NULL,
                       descricao VARCHAR(255),
                       preco DECIMAL(10, 2) NOT NULL
);
