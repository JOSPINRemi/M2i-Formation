-- Créer un utilisateur
CREATE USER 'toto'@'localhost' IDENTIFIED BY 'test';
CREATE USER 'titi'@'localhost' IDENTIFIED BY '1234';

-- Donner tous les droits
GRANT ALL PRIVILEGES ON *.* TO 'toto'@'localhost';

-- Voir les privilèges
SHOW GRANTS;

-- Donner tous les droits sur une base spécifique
GRANT ALL PRIVILEGES ON entreprise_demo.* TO 'titi'@'localhost';

-- Donner les droits en lecture sur une bdd
GRANT SELECT ON exercices.adresse TO 'titi'@'localhost';
GRANT INSERT, DELETE ON exercices.personne TO 'titi'@'localhost';

-- Donne l'accès à la colonne nom et prénom de personne
GRANT SELECT (nom, prenom) ON exercices.personne TO 'titi'@'localhost';

-- Recharger la table des droits
FLUSH PRIVILEGES;

SHOW GRANTS FOR 'titi'@'localhost';