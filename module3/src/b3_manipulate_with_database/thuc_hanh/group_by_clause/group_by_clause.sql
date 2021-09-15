use classicmodels;

-- tinh tong so tien cua don hang theo trang thai
SELECT 
    status, SUM(quantityOrdered * priceEach) AS amount
FROM
    orders
        INNER JOIN
    orderdetails ON orders.ordernumber = orderdetails.ordernumber
GROUP BY status;

-- tinh tong tien cua tung don dat hang
SELECT 
    orderNumber, SUM(quantityOrdered * priceEach) AS total
FROM
    orderdetails
GROUP BY orderNumber;

-- tinh tong so tien cua don hang theo nam va co nam lon hon 2003
SELECT 
    YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orders
        INNER JOIN
    orderdetails ON orders.orderNumber = orderdetails.orderNumber
WHERE
    status = 'shipped'
GROUP BY year
HAVING year > 2003;