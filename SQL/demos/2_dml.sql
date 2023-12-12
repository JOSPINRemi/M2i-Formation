USE entreprise_demo;

-- Méthode 1
-- Sans préciser les colonnes
INSERT INTO service
VALUES(NULL, 'RM', '2023-12-12');

-- Méthode 2
-- En précisant les colonnes
INSERT INTO service (libelle, date_modification)
VALUES
		('compta', '2023-12-11'),
		('tech', '2023-12-10');

-- Méthode 3
-- Via requete imbriquée
INSERT INTO service (libelle,date_modification)
SELECT 
'R&D' as libelle,
'2023-12-09' as date_modification;


SELECT * FROM service;