CREATE TABLE IF NOT EXISTS Shaverma_Order
(
    id              BIGINT AUTO_INCREMENT,
    delivery_name   VARCHAR(50) NOT NULL,
    delivery_Street VARCHAR(50) NOT NULL,
    delivery_City   VARCHAR(50) NOT NULL,
    delivery_State  VARCHAR(50) NOT NULL,
    delivery_Zip    VARCHAR(1)  NOT NULL,
    cc_number       VARCHAR(16) NOT NULL,
    cc_expiration   VARCHAR(5)  NOT NULL,
    cc_cvv          VARCHAR(3)  NOT NULL,
    placed_at       TIMESTAMP   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Shaverma
(
    id                 BIGINT AUTO_INCREMENT,
    name               VARCHAR(50) NOT NULL,
    shaverma_order     BIGINT      NOT NULL,
    shaverma_order_key INT         NOT NULL,
    created_at         TIMESTAMP   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT shaverma_order_fk FOREIGN KEY (shaverma_order) REFERENCES Shaverma_Order (id)
);

CREATE TABLE IF NOT EXISTS Ingredient
(
    id   VARCHAR(4)  NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);

ALTER TABLE Ingredient
    ADD INDEX idx_ingredient (id);

CREATE TABLE IF NOT EXISTS Ingredient_Ref
(
    ingredient   VARCHAR(4) NOT NULL,
    shaverma     BIGINT     NOT NULL,
    shaverma_key INT        NOT NULL,
    CONSTRAINT Ingredient_fk FOREIGN KEY (ingredient) REFERENCES Ingredient (id)
);