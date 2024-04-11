CREATE DATABASE IF NOT EXISTS tp_employe_departement;

USE tp_employe_departement;

CREATE TABLE IF NOT EXISTS departement(
	id INT AUTO_INCREMENT,
    name TEXT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS salarie(
	id INT AUTO_INCREMENT,
    lastName TEXT,
    firstName TEXT,
    role TEXT,
#     departement_id INT,
    PRIMARY KEY(id)#,
#     FOREIGN KEY (departement_id) REFERENCES departement(id)
); 

