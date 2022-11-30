--liquibase formatted sql
--changeset arkadiuszf:11
CREATE TABLE carts_cart_element
(
    cart_id         VARCHAR(255),
    cart_Element_id VARCHAR(255)

);



