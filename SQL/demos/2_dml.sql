USE entreprise_demo;

-- INSERT INTO

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
-- Via requête imbriquée
INSERT INTO service (libelle,date_modification)
SELECT 
'R&D' as libelle,
'2023-12-09' as date_modification;


SELECT * FROM service;



-- DELETE FROM

-- Supprime tous les enregistrements de la table
DELETE FROM service;

-- Suppression avec condition sur l'id
DELETE FROM service WHERE service_id = 6;

-- Suppression avec condition sur le libelle
DELETE FROM service WHERE libelle = "tech";



-- UPDATE

-- Mise à jour de l'enregistrement
UPDATE
	service
SET
	libelle = 'technologie',
    date_modification = NOW()
WHERE
	service_id = 13;




-- SELECT

-- Sélectionner toutes les colonnes d'une table
SELECT * FROM service;

-- Sélectionner une colonne d'une table
SELECT libelle FROM service;

-- Sélectionner plusieurs colonnes d'une table
SELECT service_id, libelle FROM service;

-- Préfixer les colonnes du nom de la table
SELECT service.service_id, service.libelle FROM service;

INSERT INTO salarie (prenom, nom, age, salaire, service_id)
VALUES
		('jeanne', 'dupond', 35, 1500, 11),
		('jacques', 'chirac', 62, 3500, 12),
		('michelle', 'obama', 54, 1200, 13),
		('roberta', 'patinsona', 31, 5000, 11),
		('michael', 'patate', 36, 2500, 11),
		('robert', 'patinson', 32, 5000, 11),
		('robert', 'patinson', 32, 5000, 11);

SELECT * FROM salarie;

-- Sélection sur plusieurs tables
SELECT * FROM service, salarie;

-- Instruction WHERE
SELECT nom, prenom FROM salarie WHERE salaire > 1500;

SELECT prenom, nom FROM salarie WHERE salaire < 3000 AND age > 33;

SELECT prenom, nom FROM salarie WHERE age < 33 OR salaire > 3600;

SELECT prenom, nom FROM salarie WHERE age BETWEEN 33 AND 35;

-- DISTINCT : élimine les doublons
SELECT DISTINCT salaire FROM salarie;

-- LIMIT : spécifie le nombre de ligne à retourner
SELECT * FROM service LIMIT 2;

-- ORDER BY : retourne le résultat dans un ordre défini
SELECT * FROM service ORDER BY libelle; -- ASC implicite
SELECT * FROM service ORDER BY libelle DESC;

-- Requêtes imbriquées
SELECT nom, prenom
	FROM (SELECT * FROM salarie WHERE prenom LIKE 'r%') AS prenom_en_r
    WHERE age > 25;

SELECT service_id, count(service_id) AS "nombre de salarie" FROM salarie GROUP BY service_id;

SELECT service_id, COUNT(service_id) AS "nombre de salarie" FROM salarie GROUP BY service_id;

SELECT * FROM salarie;

SELECT * FROM salarie WHERE nom = "chirac"; 

SELECT * FROM salarie WHERE salarie_id = 2; -- recherche par colonne indexe plus efficace

SELECT service_id, avg(salaire) FROM salarie GROUP BY service_id HAVING avg(salaire) > 3000 LIMIT 0, 100;