SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS drink (
id int PRIMARY KEY auto_increment,
type VARCHAR
);

CREATE TABLE IF NOT EXISTS nonAlcoholic (
id int PRIMARY KEY auto_increment,
ingredients VARCHAR,
drinkId INTEGER
);


CREATE TABLE IF NOT EXISTS alcoholic (
id int PRIMARY KEY auto_increment,
naId VARCHAR,
alcoholType VARCHAR
);

