USE exercices;
-- Exercice 3
DROP TABLES IF EXISTS etudiant_professeur, professeur, etudiant;

CREATE TABLE IF NOT EXISTS professeur(
	professeur_id INT AUTO_INCREMENT PRIMARY KEY,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    num_classe INT,
    num_departement INT,
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

INSERT INTO professeur (prenom, nom, num_classe, num_departement, email, telephone)
				VALUES
					("Mathieu", "NEBRA", 1, 1, "m.nebra@openclassrooms.fr", "0123456789"),
					("Albert", "EINSTEIN", 1, 1, "a.einstein@mc2.com", "0501303020"),
					("Alan", "TURING", 1, 1, "a.turing@computer.com", "0010100111");
SELECT * FROM professeur;
                
INSERT INTO etudiant (prenom, nom, telephone, num_classe, date_obtention_diplome)
				VALUES("Rémi", "JOSPIN", "0123456789", 1, '2023-12-12');
SELECT * FROM etudiant;

INSERT INTO etudiant_professeur (etudiant_id, professeur_id)
						VALUES
							(1, 1),
							(1, 2),
							(1, 3);
SELECT * FROM etudiant_professeur;

SELECT num_departement, professeur.num_classe,
	etudiant_id, etudiant.nom, etudiant.prenom, etudiant.telephone, date_obtention_diplome,
    professeur_id, professeur.nom, professeur.prenom, professeur.email, professeur.telephone
	FROM professeur
		JOIN etudiant_professeur USING (professeur_id)
		JOIN etudiant USING (etudiant_id);