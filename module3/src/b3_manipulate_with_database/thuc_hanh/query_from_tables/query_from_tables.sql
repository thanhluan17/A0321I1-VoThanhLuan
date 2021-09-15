use classicmodels;

-- hien thi thong tin khach hang va thong tin thanh toan tu 2 bang voi dieu kien
SELECT 
    customers.customerNumber,
    customerName,
    phone,
    paymentDate,
    amount
FROM
    customers
        INNER JOIN
    payments ON customers.customerNumber = payments.customerNumber
WHERE
    city = 'Las Vegas';

-- hien thi tat ca don hang thuoc tung khach hang bang cach su dung left join
SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber;
    
-- hien thi tat ca khach hang chua dat bat ky san pham nao
SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
WHERE
    orderNumber IS NULL;
    
