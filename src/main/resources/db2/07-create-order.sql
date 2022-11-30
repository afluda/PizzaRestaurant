--liquibase formatted sql
--changeset arkadiuszf:7
CREATE TABLE orders
(
    id      VARCHAR(255),
    date    timestamp without time zone,
    cart_id VARCHAR(255) DEFAULT null,
    user_id VARCHAR(255) DEFAULT null,
    PRIMARY KEY (id)


)
