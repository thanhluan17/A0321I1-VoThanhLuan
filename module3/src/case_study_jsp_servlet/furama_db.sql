CREATE DATABASE furama_resort_db;
USE furama_resort_db;

CREATE TABLE position (
    position_id INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(45) NOT NULL,
    CHECK (position_name IN ('Le tan' , 'Phuc vu',
        'Chuyen vien',
        'Giam sat',
        'Quan ly',
        'Giam doc'))
);

CREATE TABLE education_degree (
    education_degree_id INT AUTO_INCREMENT PRIMARY KEY,
    education_degree_name VARCHAR(45) NOT NULL,
    CHECK (education_degree_name IN ('Trung cap' , 'Cao dang', 'Dai hoc', 'Sau dai hoc'))
);

CREATE TABLE division (
    division_id INT AUTO_INCREMENT PRIMARY KEY,
    division_name VARCHAR(45) NOT NULL,
    CHECK (division_name IN ('Sale - Marketing' , 'Hanh chinh', 'Phuc vu', 'Quan ly'))
);

CREATE TABLE role (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255)
);

CREATE TABLE user (
    username VARCHAR(255) PRIMARY KEY NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_role (
    role_id INT,
    FOREIGN KEY (role_id)
        REFERENCES role (role_id),
    username VARCHAR(255),
    FOREIGN KEY (username)
        REFERENCES user (username)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE,
    employee_id_card VARCHAR(15) NOT NULL,
    employee_salary DOUBLE,
    CHECK (employee_salary >= 0),
    employee_phone CHAR(10) UNIQUE,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT,
    FOREIGN KEY (position_id)
        REFERENCES position (position_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    education_degree_id INT,
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    division_id INT,
    FOREIGN KEY (division_id)
        REFERENCES division (division_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    username VARCHAR(255),
    FOREIGN KEY (username)
        REFERENCES `user` (username)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE customer_type (
    customer_type_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_type_name VARCHAR(45),
    CHECK (customer_type_name IN ('Diamond' , 'Platinium', 'Gold', 'Silver', 'Member'))
);

CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_type_id INT,
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE,
    customer_gender BIT(1),
    customer_id_card VARCHAR(15) NOT NULL,
    customer_phone CHAR(10) UNIQUE,
    customer_email VARCHAR(45) UNIQUE,
    customer_address VARCHAR(45)
);

CREATE TABLE service_type (
    service_type_id INT AUTO_INCREMENT PRIMARY KEY,
    service_type_name VARCHAR(45) NOT NULL,
    CHECK (service_type_name IN ('Villa' , 'House', 'Room'))
);

CREATE TABLE rent_type (
    rent_type_id INT AUTO_INCREMENT PRIMARY KEY,
    rent_type_name VARCHAR(45) NOT NULL,
    CHECK (rent_type_name IN ('Nam' , 'Thang', 'Ngay', 'Gio')),
    rent_type_cost DOUBLE NOT NULL,
    CHECK (rent_type_cost >= 0)
);

CREATE TABLE service (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    CHECK (service_area > 0),
    service_cost DOUBLE,
    CHECK (service_cost >= 0),
    service_max_people INT,
    CHECK (service_max_people > 0),
    rent_type_id INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    service_type_id INT,
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    CHECK (pool_area >= 0),
    number_of_floor INT,
    CHECK (number_of_floor >= 0)
);

CREATE TABLE attach_service (
    attach_service_id INT AUTO_INCREMENT PRIMARY KEY,
    attach_service_name VARCHAR(45) NOT NULL,
    attach_service_cost DOUBLE,
    CHECK (attach_service_cost >= 0),
    attach_service_unit INT,
    CHECK (attach_service_unit >= 0),
    attach_service_status VARCHAR(45)
);


CREATE TABLE contract (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_start_date DATE NOT NULL,
    contract_end_date DATE NOT NULL,
    CHECK (contract_end_date >= contract_start_date),
    contract_deposit DOUBLE,
    CHECK (contract_deposit >= 0),
    contract_total_money DOUBLE,
    CHECK (contract_total_money >= 0),
    employee_id INT,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    customer_id INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    service_id INT,
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE contract_detail (
    contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_id INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (contract_id),
    attach_service_id INT,
    FOREIGN KEY (attach_service_id)
        REFERENCES attach_service (attach_service_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    quantity INT,
    CHECK (quantity >= 0)
);


