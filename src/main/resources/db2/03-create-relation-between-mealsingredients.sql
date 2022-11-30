--liquibase formatted sql
--changeset arkadiuszf:3

CREATE TABLE meal_ingredients
(

    meal_id  VARCHAR(255),
    ingredients VARCHAR(255),
    FOREIGN KEY (meal_id) REFERENCES "meals"(id)



);
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a44xa','Salami');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a44xa','ser');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a44xa','kukurydza');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs1','peperoni');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs1','ser');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs1','kukurydza');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs2','ser');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs2','sos-pomidorowy');
INSERT INTO meal_ingredients VALUES ('1e325e90-de9c-4fd7-8523-220ce45a4xs2','oregano');