/* DELETE 'CardboardStrava' database */
DROP SCHEMA IF EXISTS CardboardStrava;
/* DELETE USER 'user' AT LOCAL SERVER */
DROP USER IF EXISTS 'user'@'localhost';

/* CREATE 'CardboardStrava' DATABASE */
CREATE SCHEMA CardboardStrava;
/* CREATE THE USER 'user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER IF NOT EXISTS 'user'@'localhost' IDENTIFIED BY 'password';

GRANT ALL ON CardboardStrava.* TO 'user'@'localhost';