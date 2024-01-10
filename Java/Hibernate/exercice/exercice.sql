CREATE DATABASE IF NOT EXISTS exercice;
USE exercice;

SELECT * FROM exercice.produit;
SELECT * FROM exercice.image;
SELECT * FROM exercice.commentaire;

# DROP TABLES IF EXISTS image, commentaire, produit;

SELECT * FROM exercice.commentaire;
SELECT produit_id FROM exercice.commentaire GROUP BY produit_id HAVING avg(note) > 1;