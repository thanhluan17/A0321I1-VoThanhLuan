create database foreign_key_set;
use foreign_key_set;

CREATE TABLE customers(
   id INT AUTO_INCREMENT,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255),
   PRIMARY KEY(id)
);

-- tao khoa ngoai customer_id
CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   customer_id INT,
   PRIMARY KEY(id),
   FOREIGN KEY (customer_id) REFERENCES customers(id)
);

