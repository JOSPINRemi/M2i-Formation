-- Categories
-- Question 1
SELECT DISTINCT nom AS "noms de categories distinctes"FROM categories;

-- Question 2
SELECT nom AS "Categories commençant part A ou S" FROM categories WHERE nom LIKE "A%" OR nom LIKE "S%";

-- Question 3
SELECT * FROM categories WHERE ID BETWEEN 2 AND 5;

-- Question 4
SELECT DISTINCT count(*) AS "Nombre de categories distinctes" FROM categories;

-- Question 5
SELECT * FROM categories WHERE length(nom) = (SELECT MAX(length(nom)) FROM categories);

-- Question 6
SELECT c.Nom, count(*) AS "Nombre de jeux dans la categorie" FROM categories AS c JOIN jeux AS j ON c.ID = j.ID_Categorie GROUP BY c.ID;

-- Question 7
SELECT * FROM categories ORDER BY nom DESC;


-- Jeux
-- Question 1
SELECT DISTINCT nom AS "noms de jeux distincts"FROM jeux;

-- Question 2
SELECT * FROM jeux WHERE Prix BETWEEN 25 AND 40;

-- Question 3
SELECT * FROM jeux WHERE ID_Categorie = 3;

-- Question 4
SELECT count(*) FROM jeux WHERE Description LIKE '%aventure%';

-- Question 5
SELECT * FROM jeux WHERE Prix = (SELECT min(Prix) FROM jeux);

-- Question 6
SELECT sum(Prix) AS 'Somme totale des prix de tous les jeux' FROM jeux;

-- Question 7
SELECT * FROM jeux ORDER BY Nom LIMIT 5;


-- Clients
-- Question 1
SELECT DISTINCT Prenom AS "noms de clients distincts"FROM clients;

-- Question 2
SELECT * FROM clients WHERE Adresse_de_livraison LIKE "%Rue%" AND Telephone LIKE "+1%";

-- Question 3
SELECT * FROM clients WHERE nom LIKE "M%" OR nom LIKE "R%";

-- Question 4
SELECT count(*) AS "Nombre de clients avec adresse mail valide" FROM clients WHERE Adresse_mail LIKE "%@%";

-- Question 5
SELECT Prenom FROM clients WHERE length(prenom) = (SELECT MIN(length(prenom)) FROM clients);

-- Question 6
SELECT count(*) AS "Nombre de clients enregistres" FROM clients;

-- Question 7
-- SELECT * FROM clients ORDER BY Nom OFFSET 3;