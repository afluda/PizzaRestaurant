--liquibase formatted sql
--changeset arkadiuszf:8
CREATE TABLE cart_elements
(
    id      VARCHAR(255),
    cart_id    VARCHAR(255) DEFAULT null,
    meal_id VARCHAR(255) DEFAULT null,
    quantity VARCHAR(255) DEFAULT null,
    PRIMARY KEY (id)



)