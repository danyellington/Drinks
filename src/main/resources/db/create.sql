SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS drinks (
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
drinkId VARCHAR,
alcoholType VARCHAR
);


CREATE TABLE IF NOT EXISTS nonAlcoholic_alcoholic (
id int PRIMARY KEY auto_increment,
drinkId VARCHAR,
nonAlcoholicId VARCHAR,
alcoholicId VARCHAR
);