--liquibase formatted sql
--changeset arkadiuszf:1

CREATE TABLE users
(
    id        VARCHAR(255),
    city      VARCHAR(255) default null,
    email     VARCHAR(255) UNIQUE not null,
    last_name VARCHAR(255) default null,
    name      VARCHAR(255) default null,
    password  VARCHAR(255)        not null,
    street    VARCHAR(255) default null,
    "order_id" VARCHAR(255) default null,
    PRIMARY KEY (id)

);


INSERT INTO users VALUES (gen_random_uuid(), 'Rzeszów', 'test@gmail.com', 'test', 'test1', '1234', 'Grunwaldzka');
INSERT INTO users VALUES ('1e325e90-de9c-4fd7-8523-220ce45a15da', 'Warszawa', 'test1@gmail.com', 'test2', 'test2', '12345', 'Grunwaldzka1');

