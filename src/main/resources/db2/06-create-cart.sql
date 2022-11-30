--liquibase formatted sql
--changeset arkadiuszf:6
CREATE TABLE carts
(
    id          VARCHAR(255),
    cart_Element_id VARCHAR(255) DEFAULT null,
    order_id   VARCHAR(255) DEFAULT null,
    PRIMARY KEY (id)


)