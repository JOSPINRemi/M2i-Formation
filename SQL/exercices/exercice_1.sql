USE exercices;
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

INSERT INTO personne (titre, prenom, nom, telephone, email)
			VALUES
					('Mme', 'Sandy', 'Test', '0123456789', 'sandy@test.com'),
					('Mr', 'Patrick', 'Test', '0123456789', 'patrick@test.com'),
					('Mme', 'Lea', 'Test', '0123456789', 'lea@test.com'),
					('Mr', 'Ecouteur', 'Test', '0123456789', 'ecouteur@test.com'),
					('Mme', 'Tata', 'Test', '0123456789', 'tata@test.com');
SELECT * FROM personne;

INSERT INTO adresse (personne_id, rue, ville, code_postal)
			VALUES
					(1, '258 boulevard Voltaire', 'Arras', 62000),
					(2, '17 rue Dupont', 'Tourcoing', 59200),
					(3, '17 rue Dupont', 'Roubaix', 59100),
					(1, '17 rue Dupont', 'Lille', 59000);
SELECT * FROM adresse;

SELECT personne.personne_id ,titre, nom, prenom, email, telephone, adresse_id, rue, ville, code_postal
	FROM personne
		JOIN adresse USING (personne_id);