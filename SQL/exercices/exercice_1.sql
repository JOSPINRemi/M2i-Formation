-- Exercice 1
DROP TABLES IF EXISTS adresse, personne;

CREATE TABLE IF NOT EXISTS personne(
	personne_id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(3),
    prenom VARCHAR(25),
    nom VARCHAR(25),
    telephone VARCHAR(10),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS adresse(
	adresse_id INT AUTO_INCREMENT PRIMARY KEY,
	personne_id INT NOT NULL,
	rue VARCHAR(255),
	ville VARCHAR(255),
	code_postal INT,
    CONSTRAINT fk_personne_personne_id FOREIGN KEY (personne_id) REFERENCES personne(personne_id)
);
