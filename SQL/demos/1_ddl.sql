/****************************************
	Manipulation des bases de données
****************************************/
-- Création de base de données
CREATE DATABASE IF NOT EXISTS entreprise_demo
	CHARACTER SET = 'utf8mb4'
    COLLATE = 'utf8mb4_general_ci';

-- Permet d'afficher toutes les bases de données
SHOW DATABASES;

-- Suppression de la base de données si celle-ci existe
DROP DATABASE IF EXISTS entreprise_demo;


-- Modification de base de données
-- ALTER DATABASE entreprise_demo COMMENT = 'Base de données démo';
ALTER DATABASE entreprise_demo CHAR SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER DATABASE entreprise_demo DEFAULT CHARACTER SET utf8mb4;
ALTER DATABASE entreprise_demo ENCRYPTION = 'Y';

-- Afficher les schémas des bases de données
SELECT * FROM information_schema.SCHEMATA;

-- Utiliser la base de données
USE world;
USE entreprise_demo;

/******************************
	Manipulation des tables
******************************/
DROP DATABASE IF EXISTS entreprise_demo;
CREATE DATABASE IF NOT EXISTS entreprise_demo
	CHARACTER SET = 'utf8mb4'
    COLLATE = 'utf8mb4_general_ci';
USE entreprise_demo;

-- Création d'une seconde table
CREATE TABLE IF NOT EXISTS service(
	service_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(150) NOT NULL
);

-- Création d'une table si elle n'existe pas
CREATE TABLE IF NOT EXISTS salarie(
	salarie_id INT NOT NULL AUTO_INCREMENT, -- clé primaire qui s'auto-incrémente
    prenom VARCHAR(50) NOT NULL, -- obligation de fournir une valeur
    nom VARCHAR(50) NOT NULL, -- obligation de fournir une valeur
    age INT NOT NULL CHECK(age > 18 AND age < 65), -- contrainte pour vérifier l'âge
    salaire FLOAT NOT NULL DEFAULT 1500, -- valeur par défaut
    service_id INT NOT NULL, -- ajout de la colonne pour la clé étrangère
    PRIMARY KEY(salarie_id),
    CONSTRAINT fk_service_id FOREIGN KEY(service_id) REFERENCES service(service_id)
);

-- Supression de la table
DROP TABLE IF EXISTS salarie;

-- Afficher les tables
SHOW TABLES;

-- Afficher le détail des colonnes
SHOW COLUMNS FROM salarie;
SHOW COLUMNS FROM service;

-- Ajout de la contrainte après création de la table
ALTER TABLE salarie
	ADD CONSTRAINT fk_service_id FOREIGN KEY(service_id) REFERENCES service(service_id);

-- Ajouter une colonne date-heure
ALTER TABLE service
	ADD COLUMN date_modification DATETIME;

-- Modifier la colonne en type DATE
ALTER TABLE service
	MODIFY COLUMN date_modification DATE;