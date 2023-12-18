CREATE DATABASE exercice_1_jdbc;

USE exercice_1_jdbc;

CREATE TABLE student (
	last_name VARCHAR(200),
    first_name VARCHAR(200),
    class_number INT,
    degree_date DATE
);

DROP TABLE student;
DROP DATABASE exercice_1_jdbc;