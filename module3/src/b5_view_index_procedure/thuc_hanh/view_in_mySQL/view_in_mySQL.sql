USE classicmodels;

-- tao mot view voi cac truong duoc lay tu cau lenh select tu bang customers
CREATE VIEW customer_views AS
    SELECT 
        customerNumber, customerName, phone
    FROM
        customers;

-- hien thi ket qua tu view
SELECT 
    *
FROM
    customer_views;
    
-- cap nhat view de them 1 cot vao view
CREATE OR REPLACE VIEW customer_views AS
    SELECT 
        customerNumber,
        customerName,
        contactFirstName,
        contactLastName,
        phone
    FROM
        customers
    WHERE
        city = 'Nantes';
        
-- hien thi lai ket qua tu view
SELECT 
    *
FROM
    customer_views;
    
-- dung DROP VIEW de xoa view
DROP VIEW customer_views;

