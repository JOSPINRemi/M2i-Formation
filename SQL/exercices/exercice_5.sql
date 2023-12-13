-- Exercice 5
CREATE DATABASE IF NOT EXISTS exercice_5;

USE exercice_5;

-- Question 1
SELECT 
    *
FROM
    villes_france_free
ORDER BY ville_population_2012 DESC
LIMIT 10;

-- Question 2
SELECT 
    *
FROM
    villes_france_free
ORDER BY ville_surface
LIMIT 50;

-- Question 3
SELECT 
    *
FROM
    departement
WHERE
    departement_code LIKE '97%';

-- Question 4
SELECT 
    ville_nom,
    departement_nom
FROM
    villes_france_free
        JOIN
    departement ON ville_departement = departement_code
ORDER BY ville_population_2012 DESC
LIMIT 10;

-- Question 5
SELECT 
    departement_nom AS "Departement",
    departement_code AS "Code departement",
    count(*) AS nbr_commune
FROM
    departement
        JOIN
    villes_france_free ON departement_code = ville_departement
GROUP BY departement_nom, departement_code
ORDER BY nbr_commune DESC;

-- Question 6
SELECT 
    departement_nom,
    ville_departement,
    SUM(ville_surface) AS dpt_surface
FROM
    departement
        JOIN
    villes_france_free
GROUP BY departement_nom , ville_departement
LIMIT 10;

-- Question 7
SELECT 
    COUNT(*)
FROM
    villes_france_free
WHERE
    ville_nom LIKE 'Saint%';

-- Question 8
SELECT 
    ville_nom,
    COUNT(*) AS nb_ville
FROM
    villes_france_free
GROUP BY ville_nom
HAVING nb_ville > 1
ORDER BY nb_ville DESC;

-- Question 9
SELECT 
    ville_nom, ville_surface
FROM
    villes_france_free
WHERE
    ville_surface > (SELECT 
            AVG(ville_surface)
        FROM
            villes_france_free)
ORDER BY ville_surface;

-- Question 10
SELECT 
    ville_departement,
    departement_nom,
    SUM(ville_population_2012) AS population_2012
FROM
    villes_france_free
        INNER JOIN
    departement ON departement_code = ville_departement
GROUP BY ville_departement , departement_nom
HAVING population_2012 > 2000000;

-- Question 11
UPDATE
	villes_france_free
SET
	ville_nom = replace(ville_nom, '-', ' ')
WHERE ville_nom LIKE 'SAINT-%';

SELECT 
    COUNT(*)
FROM
    villes_france_free
WHERE
    ville_nom LIKE 'Saint-%';