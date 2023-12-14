CREATE DATABASE IF NOT EXISTS transac;
USE transac;

CREATE TABLE IF NOT EXISTS utilisateurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    age INT
);

CREATE TABLE IF NOT EXISTS commandes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    utilisateur_id INT,
    produit VARCHAR(50),
    quantite INT,
    FOREIGN KEY (utilisateur_id)
        REFERENCES utilisateurs (id)
);

INSERT INTO utilisateurs (nom, prenom, age)
VALUES
		("DOE", "John", floor(rand() * 50) + 18),
		("SMITH", "Jahn", floor(rand() * 50) + 18),
		("BROWN", "David", floor(rand() * 50) + 18);

SELECT 
    *
FROM
    utilisateurs;

INSERT INTO commandes (utilisateur_id, produit, quantite)
VALUES
		(1, "Produit A", floor(rand() * 5) + 1),
		(2, "Produit B", floor(rand() * 5) + 1),
		(3, "Produit C", floor(rand() * 5) + 1);
        
SELECT 
    *
FROM
    commandes;

-- Début de la transaction
-- BEGIN
START TRANSACTION;

-- Insérer un nouvel utilisateur
INSERT INTO utilisateurs (nom, prenom, age)
VALUES
		("ALL", "Good", floor(rand() * 50) + 18);

-- Recup du dernier id utilisateur inséré
SET @utilisateur_id = last_insert_id();

INSERT INTO commandes (utilisateur_id, produit, quantite)
VALUES
		(@utilisateur_id, "Produit D", floor(rand() * 5) + 1);

-- Valider ma transaction
COMMIT;


-- Début de la transaction
-- BEGIN
BEGIN;

-- Insérer un nouvel utilisateur
INSERT INTO utilisateurs (nom, prenom, age)
VALUES
		("NOTALL", "Good", floor(rand() * 50) + 18);

-- Recup du dernier id utilisateur inséré
SET @utilisateur_id = last_insert_id();

INSERT INTO commandes (utilisateur_id, produit, quantite)
VALUES
		(@utilisateur_id, "Produit B", floor(rand() * 5) + 1);

-- Annuler ma transaction
ROLLBACK;