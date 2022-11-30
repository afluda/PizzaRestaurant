--liquibase formatted sql
--changeset arkadiuszf:14

ALTER TABLE carts_cart_element
    ADD CONSTRAINT cart_id
        FOREIGN KEY (cart_id) REFERENCES "carts" (id),
    ADD CONSTRAINT cart_Element_id
        FOREIGN KEY (cart_Element_id) REFERENCES cart_elements (id)

