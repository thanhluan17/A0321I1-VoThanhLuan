USE classicmodels;

-- ket qua tang toc SQL
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;

-- them chi muc cho bang customers
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);

-- xem lai ket qua tang toc
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;

-- them chi muc cho 2 cot contactFirstName va contactLastName
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

-- dung DROP INDEX de xoa chi muc
ALTER TABLE customers DROP INDEX idx_full_name;