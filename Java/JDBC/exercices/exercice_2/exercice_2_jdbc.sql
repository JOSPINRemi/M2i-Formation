CREATE DATABASE exercice_2_jdbc;

USE exercice_2_jdbc;

CREATE TABLE client(
	nom VARCHAR(50),
	prenom VARCHAR(50),
	id INT AUTO_INCREMENT PRIMARY KEY,
    telephone VARCHAR(12)
);

CREATE TABLE compte_bancaire(
	id INT AUTO_INCREMENT PRIMARY KEY,
	solde DOUBLE,
    client_id INT,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE operation(
	numero INT AUTO_INCREMENT PRIMARY KEY,
    montant DOUBLE,
    statut TEXT,
	compte_id INT,
    CONSTRAINT fk_compte_id FOREIGN KEY (compte_id) REFERENCES compte_bancaire(id)
);