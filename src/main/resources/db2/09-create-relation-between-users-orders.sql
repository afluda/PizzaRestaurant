--liquibase formatted sql
--changeset arkadiuszf:9

ALTER TABLE users
    ADD CONSTRAINT "order_id"
        FOREIGN KEY ("order_id") REFERENCES "orders" (id)
