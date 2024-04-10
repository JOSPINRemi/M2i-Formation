CREATE DATABASE IF NOT EXISTS cruddbswing;

USE cruddbswing;

CREATE TABLE IF NOT EXISTS contact (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    number TEXT
);