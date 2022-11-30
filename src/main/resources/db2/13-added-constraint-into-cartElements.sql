--liquibase formatted sql
--changeset arkadiuszf:13

ALTER TABLE cart_elements
    ADD CONSTRAINT "cart_id"
        FOREIGN KEY ("cart_id") REFERENCES "carts" (id),
    ADD CONSTRAINT "meal_id"
        FOREIGN KEY ("meal_id") REFERENCES "meals" (id);

