-- Exercice 4
-- CREATE DATABASE IF NOT EXISTS exercice_4;

-- USE exercice_4;

-- DROP TABLE IF EXISTS livre;

-- Question 1
-- CREATE TABLE IF NOT EXISTS livre(
-- 	id INT AUTO_INCREMENT PRIMARY KEY,
--     titre VARCHAR(150),
--     auteur VARCHAR(50),
--     editeur VARCHAR(50),
--     date_publication DATE,
--     isbn_10 VARCHAR(10),
--     isbn_13 VARCHAR(15)
-- );

-- Question 3
SELECT 
    *
FROM
    (SELECT 
        *
    FROM
        exercice_4.livre
    ORDER BY date_publication
    LIMIT 10) AS dix_livres_plus_anciens
ORDER BY id ASC;

-- Question 4
SELECT 
    date_publication, auteur, titre
FROM
    exercice_4.livre
ORDER BY date_publication
LIMIT 10;

-- Question 5
SELECT 
    *
FROM
    exercice_4.livre
WHERE
    auteur = 'Agatha Christie';

-- Question 6
UPDATE exercice_4.livre 
SET 
    auteur = 'Agatha Christie'
WHERE
    auteur = 'Agatha Christies';

-- Question 7
INSERT INTO livre (titre, auteur, editeur, date_publication, isbn_10, isbn_13)
VALUES 
	("Les Aventures d'Alice au pays des merveilles",'Lewis Carroll','Macmillan and Co', '1864-07-04','2000000000','978-0000000000');

-- Question 8
DELETE FROM exercice_4.livre 
WHERE
    auteur = 'Arthur Rimbaud'
    AND titre = 'Les Cahiers de Douai';