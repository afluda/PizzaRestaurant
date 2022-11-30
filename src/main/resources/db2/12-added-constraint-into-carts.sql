--liquibase formatted sql
--changeset arkadiuszf:112

ALTER TABLE carts
    ADD CONSTRAINT "orderId"
        FOREIGN KEY ("order_id") REFERENCES "orders"(id);
