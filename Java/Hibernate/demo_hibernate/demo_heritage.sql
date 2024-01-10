CREATE DATABASE IF NOT EXISTS demo_heritage;
USE demo_heritage;

-- Exemple joined table :
SELECT * FROM demo_heritage.payment;
SELECT * FROM demo_heritage.credit_card;
SELECT * FROM demo_heritage.paypal;

-- Exemple single table
SELECT * FROM demo_heritage.payment1;

-- Exemple table per class :
SELECT * FROM demo_heritage.hibernate_sequence;
SELECT * FROM demo_heritage.credit_payment2;
SELECT * FROM demo_heritage.paypal2;

SELECT * FROM demo_heritage.personne;

SELECT * FROM demo_heritage.employee;

SELECT * FROM demo_heritage.agence;