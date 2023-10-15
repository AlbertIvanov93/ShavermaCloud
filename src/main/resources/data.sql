DELETE
FROM Ingredient_Ref;
DELETE
FROM Shaverma;
DELETE
FROM Shaverma_Order;
DELETE
FROM Ingredient;

INSERT INTO Ingredient (id, name, type)
VALUES ('LAVA', 'Lavash', 'WRAP');
INSERT INTO Ingredient (id, name, type)
VALUES ('CHLA', 'Cheese Lavash', 'WRAP');
INSERT INTO Ingredient (id, name, type)
VALUES ('PITA', 'Pita', 'WRAP');
INSERT INTO Ingredient (id, name, type)
VALUES ('ONPL', 'On Plate', 'WRAP');
INSERT INTO Ingredient (id, name, type)
VALUES ('PORK', 'Pork', 'PROTEIN');
INSERT INTO Ingredient (id, name, type)
VALUES ('CHIC', 'Chicken', 'PROTEIN');
INSERT INTO Ingredient (id, name, type)
VALUES ('ONIO', 'Onion', 'VEGGIES');
INSERT INTO Ingredient (id, name, type)
VALUES ('CUCU', 'Cucumber', 'VEGGIES');
INSERT INTO Ingredient (id, name, type)
VALUES ('PICK', 'Pickles', 'VEGGIES');
INSERT INTO Ingredient (id, name, type)
VALUES ('TOMA', 'Tomato', 'VEGGIES');
INSERT INTO Ingredient (id, name, type)
VALUES ('KCAR', 'Korean Carrots', 'VEGGIES');
INSERT INTO Ingredient (id, name, type)
VALUES ('JALA', 'Jalapeno', 'VEGGIES');
INSERT INTO Ingredient (id, name, type)
VALUES ('CHED', 'Cheddar', 'CHEESE');
INSERT INTO Ingredient (id, name, type)
VALUES ('PARM', 'Parmesan', 'CHEESE');
INSERT INTO Ingredient (id, name, type)
VALUES ('GASA', 'Garlic Sauce', 'SAUCE');
INSERT INTO Ingredient (id, name, type)
VALUES ('SPSA', 'Spicy Sauce', 'SAUCE');
INSERT INTO Ingredient (id, name, type)
VALUES ('SCSA', 'Sour Cream Sauce', 'SAUCE');