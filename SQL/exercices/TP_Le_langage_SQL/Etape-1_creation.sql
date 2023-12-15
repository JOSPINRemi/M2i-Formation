-- Question 1
CREATE DATABASE tabletoptreasures_database;

USE tabletoptreasures_database;

-- Queestion 2
CREATE TABLE Clients (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(50) NOT NULL,
    Prenom VARCHAR(50) NOT NULL,
    Adresse_mail VARCHAR(150) NOT NULL,
    Adresse_de_livraison VARCHAR(150),
    Telephone VARCHAR(11)
);
CREATE TABLE Categories (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(10) NOT NULL
);
CREATE TABLE Jeux (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(30) NOT NULL,
    Description VARCHAR(500),
    Prix INT NOT NULL,
    ID_Categorie INT NOT NULL,
    FOREIGN KEY (ID_Categorie)
        REFERENCES Categories (ID)
);
CREATE TABLE Commandes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Client INT NOT NULL,
    Date_de_commande DATE NOT NULL,
    Adresse_de_livraison VARCHAR(150) NOT NULL,
    Statut VARCHAR(50),
    FOREIGN KEY (ID_Client)
        REFERENCES Clients (ID)
);