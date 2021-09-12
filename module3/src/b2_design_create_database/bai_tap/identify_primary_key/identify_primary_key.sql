create database primary_key_identify;
use primary_key_identify;

-- tao bang customers co khoa chinh la customer_number
CREATE TABLE customers (
    customer_number INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    email VARCHAR(50) UNIQUE,
    phone CHAR(10) UNIQUE
);

-- tao bang accounts co khoa chinh la account_number 
CREATE TABLE accounts (
    account_number INT AUTO_INCREMENT,
    account_type VARCHAR(10) NOT NULL,
    customer_number INT,
    PRIMARY KEY (account_number),
    FOREIGN KEY (customer_number)
        REFERENCES customers (customer_number),
    `date` DATE NOT NULL,
    balance DOUBLE
);

-- tao bang transactions co khoa chinh la tran_number
CREATE TABLE transactions (
    tran_number INT AUTO_INCREMENT,
    account_number INT,
    FOREIGN KEY (account_number)
        REFERENCES accounts (account_number),
    `date` DATE NOT NULL,
    amounts DOUBLE NOT NULL,
    descriptions VARCHAR(100),
    primary key (tran_number)
);
