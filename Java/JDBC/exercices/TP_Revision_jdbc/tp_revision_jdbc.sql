CREATE DATABASE IF NOT EXISTS tp_revision_jdbc;
USE tp_revision_jdbc;

DROP TABLE IF EXISTS customer_event,customer, event, event_location;

CREATE TABLE IF NOT EXISTS event_location
(
    id       INT AUTO_INCREMENT,
    name     VARCHAR(25),
    address  VARCHAR(50),
    capacity INT,
    event_id INT,
    CONSTRAINT pk_event_location PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS event
(
    id                  INT AUTO_INCREMENT,
    name                VARCHAR(25),
    date_time           DATETIME,
    event_location_id   INT,
    price               DOUBLE,
    tickets_sold_number INT,
    CONSTRAINT pk_event PRIMARY KEY (id),
    CONSTRAINT fk_event_event_location FOREIGN KEY (event_location_id) REFERENCES event_location (id)
);
ALTER TABLE event_location
    ADD CONSTRAINT fk_event_location_event FOREIGN KEY (event_id) REFERENCES event_location (id);

CREATE TABLE IF NOT EXISTS customer
(
    id INT AUTO_INCREMENT,
    first_name VARCHAR(25),
    last_name  VARCHAR(25),
    email      VARCHAR(150),
    CONSTRAINT  pk_customer PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customer_event
(
    id          INT AUTO_INCREMENT,
    customer_id INT,
    event_id    INT,
    CONSTRAINT pk_customer_event PRIMARY KEY (id),
    CONSTRAINT fk_customer_event_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_customer_event_event FOREIGN KEY (event_id) REFERENCES event (id)
);

