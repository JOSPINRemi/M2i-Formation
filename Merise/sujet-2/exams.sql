-- Création de la base de données
CREATE DATABASE IF NOT EXISTS exams;
USE exams;

-- Création des tables
CREATE TABLE IF NOT EXISTS examen
(
    nom_examen VARCHAR(50),
    PRIMARY KEY (nom_examen)
);

CREATE TABLE IF NOT EXISTS jury
(
    Id_jury INT AUTO_INCREMENT,
    PRIMARY KEY (Id_jury)
);

CREATE TABLE IF NOT EXISTS academie
(
    Id_academie  INT AUTO_INCREMENT,
    nom_academie VARCHAR(50),
    PRIMARY KEY (Id_academie)
);

CREATE TABLE IF NOT EXISTS inspection_academique
(
    Id_inspection_academique INT AUTO_INCREMENT,
    Id_jury                  INT NOT NULL,
    PRIMARY KEY (Id_inspection_academique),
    FOREIGN KEY (Id_jury) REFERENCES jury (Id_jury)
);

CREATE TABLE IF NOT EXISTS etablissement
(
    code_etablissement VARCHAR(50),
    nom_etablissement  VARCHAR(50),
    adresse            VARCHAR(50),
    ville              VARCHAR(50),
    Id_academie        INT NOT NULL,
    PRIMARY KEY (code_etablissement),
    FOREIGN KEY (Id_academie) REFERENCES academie (Id_academie)
);

CREATE TABLE IF NOT EXISTS epreuve
(
    nom_epreuve  VARCHAR(50),
    coefficient  DECIMAL(15, 2),
    date_epreuve DATE,
    Id_jury      INT NOT NULL,
    Id_jury_1    INT NOT NULL,
    PRIMARY KEY (nom_epreuve),
    FOREIGN KEY (Id_jury) REFERENCES jury (Id_jury),
    FOREIGN KEY (Id_jury_1) REFERENCES jury (Id_jury)
);

CREATE TABLE IF NOT EXISTS enseignant
(
    matricule                VARCHAR(50),
    nom_enseignant           VARCHAR(50),
    telephone                VARCHAR(50),
    adresse                  VARCHAR(50),
    ville                    VARCHAR(50),
    Id_inspection_academique INT NOT NULL,
    Id_jury                  INT NOT NULL,
    PRIMARY KEY (matricule),
    FOREIGN KEY (Id_inspection_academique) REFERENCES inspection_academique (Id_inspection_academique),
    FOREIGN KEY (Id_jury) REFERENCES jury (Id_jury)
);

CREATE TABLE IF NOT EXISTS eleve
(
    Id_eleve           INT AUTO_INCREMENT,
    nom_eleve          VARCHAR(50) NOT NULL,
    date_naissance     DATE,
    nom_examen         VARCHAR(50) NOT NULL,
    code_etablissement VARCHAR(50),
    PRIMARY KEY (Id_eleve),
    FOREIGN KEY (nom_examen) REFERENCES examen (nom_examen),
    FOREIGN KEY (code_etablissement) REFERENCES etablissement (code_etablissement)
);

CREATE TABLE IF NOT EXISTS note
(
    Id_note     INT AUTO_INCREMENT,
    valeur      DECIMAL(15, 2),
    nom_epreuve VARCHAR(50) NOT NULL,
    Id_eleve    INT         NOT NULL,
    PRIMARY KEY (Id_note),
    FOREIGN KEY (nom_epreuve) REFERENCES epreuve (nom_epreuve),
    FOREIGN KEY (Id_eleve) REFERENCES eleve (Id_eleve)
);

CREATE TABLE IF NOT EXISTS dossier
(
    numero_dossier     INT AUTO_INCREMENT,
    code_etablissement VARCHAR(50) NOT NULL,
    Id_eleve           INT         NOT NULL,
    PRIMARY KEY (numero_dossier),
    UNIQUE (Id_eleve),
    FOREIGN KEY (code_etablissement) REFERENCES etablissement (code_etablissement),
    FOREIGN KEY (Id_eleve) REFERENCES eleve (Id_eleve)
);

CREATE TABLE IF NOT EXISTS examen_epreuve
(
    nom_examen  VARCHAR(50),
    nom_epreuve VARCHAR(50),
    PRIMARY KEY (nom_examen, nom_epreuve),
    FOREIGN KEY (nom_examen) REFERENCES examen (nom_examen),
    FOREIGN KEY (nom_epreuve) REFERENCES epreuve (nom_epreuve)
);

CREATE TABLE IF NOT EXISTS etablissement_epreuve
(
    code_etablissement VARCHAR(50),
    nom_epreuve        VARCHAR(50),
    PRIMARY KEY (code_etablissement, nom_epreuve),
    FOREIGN KEY (code_etablissement) REFERENCES etablissement (code_etablissement),
    FOREIGN KEY (nom_epreuve) REFERENCES epreuve (nom_epreuve)
);

CREATE TABLE IF NOT EXISTS etablissement_enseignant
(
    code_etablissement VARCHAR(50),
    matricule          VARCHAR(50),
    PRIMARY KEY (code_etablissement, matricule),
    FOREIGN KEY (code_etablissement) REFERENCES etablissement (code_etablissement),
    FOREIGN KEY (matricule) REFERENCES enseignant (matricule)
);

CREATE TABLE IF NOT EXISTS inspection_academique_examen
(
    nom_examen               VARCHAR(50),
    Id_inspection_academique INT,
    PRIMARY KEY (nom_examen, Id_inspection_academique),
    FOREIGN KEY (nom_examen) REFERENCES examen (nom_examen),
    FOREIGN KEY (Id_inspection_academique) REFERENCES inspection_academique (Id_inspection_academique)
);


-- Ajout d'informations dans les tables
-- Insertion de données dans la table examen
INSERT INTO examen (nom_examen)
VALUES ('Bac Mathématiques'),
       ('Bac Français'),
       ('Brevet Histoire-Géographie');

-- Insertion de données dans la table jury
-- Vous pouvez laisser cette table vide si elle est utilisée uniquement pour les clés étrangères.

-- Insertion de données dans la table academie
INSERT INTO academie (nom_academie)
VALUES ('Academie1'),
       ('Academie2'),
       ('Academie3');

-- Insertion de données dans la table inspection_academique
INSERT INTO inspection_academique (Id_jury)
VALUES (1),
       (2),
       (3);

-- Insertion de données dans la table etablissement
INSERT INTO etablissement (code_etablissement, nom_etablissement, adresse, ville, Id_academie)
VALUES ('E001', 'Lycée Victor Hugo', '1 Rue de l\'École', 'Paris', 1),
       ('E002', 'Collège Marie Curie', '2 Avenue des Étudiants', 'Lyon', 2),
       ('E003', 'Lycée Jean Moulin', '3 Boulevard des Savoirs', 'Marseille', 3);

-- Insertion de données dans la table epreuve
INSERT INTO epreuve (nom_epreuve, coefficient, date_epreuve, Id_jury, Id_jury_1)
VALUES ('Mathématiques', 0.8, '2023-05-15', 1, 2),
       ('Français', 1.2, '2023-06-20', 2, 3),
       ('Histoire-Géographie', 1.0, '2023-05-25', 3, 1);

-- Insertion de données dans la table enseignant
INSERT INTO enseignant (matricule, nom_enseignant, telephone, adresse, ville, Id_inspection_academique, Id_jury)
VALUES ('E101', 'Dupont', '0123456789', '4 Rue du Professeur', 'Paris', 1, 1),
       ('E102', 'Martin', '0987654321', '5 Avenue des Enseignants', 'Lyon', 2, 2),
       ('E103', 'Durand', '0654321098', '6 Boulevard des Notes', 'Marseille', 3, 3);

-- Insertion de données dans la table eleve
INSERT INTO eleve (nom_eleve, date_naissance, nom_examen, code_etablissement)
VALUES ('Alice Dubois', '2005-02-10', 'Bac Mathématiques', 'E001'),
       ('Paul Lefevre', '2004-08-25', 'Bac Français', 'E002'),
       ('Emma Moreau', '2006-01-05', 'Brevet Histoire-Géographie', 'E003');

-- Insertion de données dans la table note
INSERT INTO note (valeur, nom_epreuve, Id_eleve)
VALUES (14.5, 'Mathématiques', 1),
       (16.2, 'Français', 2),
       (13.8, 'Histoire-Géographie', 3);

-- Insertion de données dans la table dossier
INSERT INTO dossier (code_etablissement, Id_eleve)
VALUES ('E001', 1),
       ('E002', 2),
       ('E003', 3);

-- Insertion de données dans la table examen_epreuve
INSERT INTO examen_epreuve (nom_examen, nom_epreuve)
VALUES ('Bac Mathématiques', 'Mathématiques'),
       ('Bac Français', 'Français'),
       ('Brevet Histoire-Géographie', 'Histoire-Géographie');

-- Insertion de données dans la table etablissement_epreuve
INSERT INTO etablissement_epreuve (code_etablissement, nom_epreuve)
VALUES ('E001', 'Mathématiques'),
       ('E002', 'Français'),
       ('E003', 'Histoire-Géographie');

-- Insertion de données dans la table etablissement_enseignant
INSERT INTO etablissement_enseignant (code_etablissement, matricule)
VALUES ('E001', 'E101'),
       ('E002', 'E102'),
       ('E003', 'E103');

-- Insertion de données dans la table inspection_academique_examen
INSERT INTO inspection_academique_examen (nom_examen, Id_inspection_academique)
VALUES ('Bac Mathématiques', 1),
       ('Bac Français', 2),
       ('Brevet Histoire-Géographie', 3);


-- Tests
-- 1 - Sélectionner tous les élèves et leurs dates de naissance
SELECT nom_eleve, date_naissance
FROM eleve;

-- 2 - Trouver la note moyenne pour l'examen 'Baccalauréat'
SELECT avg(valeur)
FROM examen
         JOIN examen_epreuve as ee on examen.nom_examen = ee.nom_examen
         JOIN note as n on ee.nom_epreuve = n.nom_epreuve
WHERE examen.nom_examen = 'Baccalauréat'
GROUP BY examen.nom_examen;

-- 3 - Lister tous les enseignants travaillant à 'Paris'
SELECT nom_enseignant
FROM enseignant
         JOIN etablissement_enseignant as ee on enseignant.matricule = ee.matricule
         JOIN etablissement as e on e.code_etablissement = ee.code_etablissement
WHERE e.ville = 'Paris';

-- 4 - Compter le nombre d'élèves inscrits dans chaque établissement
SELECT nom_etablissement, count(*) as "nombre d'élèves"
FROM eleve
         JOIN etablissement as e on e.code_etablissement = eleve.code_etablissement
GROUP BY eleve.code_etablissement;

-- 5 - Obtenir les noms de tous les élèves ayant passé un examen avec une note supérieure à 15
SELECT eleve.nom_eleve
FROM eleve
         JOIN note as n on eleve.Id_eleve = n.Id_eleve
WHERE valeur > 15;

-- 6 - Afficher les examens et les noms des épreuves correspondantes avec leurs coefficients
SELECT examen.nom_examen, e.nom_epreuve, e.coefficient
FROM examen
         JOIN examen_epreuve as ee on examen.nom_examen = ee.nom_examen
         JOIN epreuve as e on ee.nom_epreuve = e.nom_epreuve;

-- 7 - Lister les établissements avec le nombre d'examens différents pris, triés par le nombre d'examens

-- 8 - Trouver tous les élèves qui n'ont passé aucun examen

-- 9 - Identifier les enseignants qui ont à la fois rédigé et corrigé la même épreuve

-- 10 - Montrer le dernier examen que chaque élève a passé, avec la date et la note
