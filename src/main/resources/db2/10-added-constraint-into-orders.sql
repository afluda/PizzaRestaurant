--liquibase formatted sql
--changeset arkadiuszf:10

ALTER TABLE orders
    ADD CONSTRAINT "cart_id"
        FOREIGN KEY ("cart_id") REFERENCES "carts" (id),
    ADD CONSTRAINT "user_id"
        FOREIGN KEY ("user_id") REFERENCES "users" (id);
