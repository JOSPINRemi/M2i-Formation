-- Exercice 3
DROP TABLES IF EXISTS etudiant_professeur, professeur, etudiant;

CREATE TABLE IF NOT EXISTS professeur(
	professeur_id INT AUTO_INCREMENT PRIMARY KEY,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    num_classe INT,
    num_departemnt INT,
	email VARCHAR(255) UNIQUE,
    telephone VARCHAR(10) UNIQUE
);

CREATE TABLE IF NOT EXISTS etudiant(
	etudiant_id INT AUTO_INCREMENT PRIMARY KEY,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    telephone VARCHAR(10) NOT NULL UNIQUE,
    num_classe INT,
    date_obtention_diplome DATE
);

CREATE TABLE IF NOT EXISTS etudiant_professeur(
	etudiant_professeur_id INT AUTO_INCREMENT PRIMARY KEY,
	etudiant_id INT NOT NULL,
    professeur_id INT NOT NULL,
    CONSTRAINT fk_etudiant_etudiant_id FOREIGN KEY (etudiant_id) REFERENCES etudiant(etudiant_id),
    CONSTRAINT fk_professeur_professeur_id FOREIGN KEY (professeur_id) REFERENCES professeur(professeur_id)
);
