CREATE DATABASE IF NOT EXISTS tp_employee;

USE tp_employee;

CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT,
    name TEXT,
    gender TEXT,
    age INT,
    blood_group TEXT,
    contact_number TEXT,
    qualification TEXT,
    start_date DATE,
    address TEXT,
    image_path TEXT,
    PRIMARY KEY (id)
);