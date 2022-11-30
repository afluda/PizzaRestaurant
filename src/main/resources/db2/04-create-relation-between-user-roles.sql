--liquibase formatted sql
--changeset arkadiuszf:4

CREATE TABLE USER_ROLES
(

    user_id    VARCHAR(255),
    roles VARCHAR(255) not null,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES "users" (id)


);
INSERT INTO USER_ROLES VALUES ('1e325e90-de9c-4fd7-8523-220ce45a15da','ROLE_USER')