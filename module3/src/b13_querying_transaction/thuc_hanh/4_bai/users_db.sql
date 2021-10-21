CREATE DATABASE b12_jdbc_crud;
USE b12_jdbc_crud;

CREATE TABLE users (
    id INT(3) NOT NULL AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120),
    PRIMARY KEY (id)
);

INSERT INTO users(name, email, country) VALUES('Minh','minh@codegym.vn','Viet Nam');
INSERT INTO users(name, email, country) VALUES('Kante','kante@che.uk','Kenia');

-- SP select user by id
DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    WHERE users.id = user_id;
    END$$
DELIMITER ;

-- SP insert new user
DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name VARCHAR(50),
IN user_email VARCHAR(50),
IN user_country VARCHAR(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

-- tao bang permission
CREATE TABLE Permision (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY(id)
);

CREATE TABLE User_Permision (
    permision_id INT(11),
		FOREIGN KEY (permision_id) REFERENCES Permision(id),
    user_id INT(11),
        FOREIGN KEY (user_id) REFERENCES users(id),
	PRIMARY KEY(permision_id, user_id)
);

INSERT INTO Permision(name) VALUES('add');
INSERT INTO Permision(name) VALUES('edit');
INSERT INTO Permision(name) VALUES('delete');
INSERT INTO Permision(name) VALUES('view');