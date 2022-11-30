--liquibase formatted sql
--changeset arkadiuszf:2

CREATE TABLE meals
(
    id          VARCHAR(255),
    name        VARCHAR(255) UNIQUE null,
    price       DECIMAL(255)        not null,
    pizza_image VARCHAR(255),
    PRIMARY KEY (id)
);
INSERT INTO meals VALUES ('1e325e90-de9c-4fd7-8523-220ce45a44xa', 'Salami', 23.99, null);
INSERT INTO meals VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs1', 'Pepperoni', 23.99, null);
INSERT INTO meals VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs2', 'Margarita', 23.99, null);
