USE exercices;
-- Exercice 4

DROP TABLE IF EXISTS livre;

CREATE TABLE IF NOT EXISTS livre(
	id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(150),
    auteur VARCHAR(50),
    editeur VARCHAR(50),
    date_publication DATE,
    isbn_10 VARCHAR(10),
    isbn_13 VARCHAR(15)
);