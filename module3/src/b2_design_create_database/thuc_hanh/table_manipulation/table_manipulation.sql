create database table_manipulation;
use table_manipulation;

-- tao bang contact
CREATE TABLE contacts (
    contact_id INT(11) NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(30) NOT NULL,
    first_name VARCHAR(25),
    birthday DATE,
    CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

-- tao bang supplier
CREATE TABLE suppliers (
    supplier_id INT(11) NOT NULL AUTO_INCREMENT,
    supplier_name VARCHAR(50) NOT NULL,
    account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
    CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

-- xoa bang contacts
DROP TABLE contacts;

-- them mot cot vao bang contacts sau cot birthday
ALTER TABLE contacts
  ADD gender VARCHAR(10)
    AFTER birthday;
    
-- chinh sua mo ta cot
ALTER TABLE contacts
  MODIFY gender boolean;
  
-- chinh sua ten cot
ALTER TABLE contacts
  CHANGE COLUMN gender gioitinh
    varchar(20);
  
-- xoa cot gioi tinh
ALTER TABLE contacts
  DROP COLUMN gioitinh;
  
-- thay doi ten bang thanh people
ALTER TABLE contacts
  RENAME TO people;

