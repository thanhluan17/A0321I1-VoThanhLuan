use classicmodels;

-- hien sp co gia lon hon 56.76 va so luong trong kho lon hon 10
SELECT 
    productCode, productName, buyprice, quantityInStock
FROM
    products
WHERE
    buyprice > 56.76
        AND quantityInStock > 10;

-- hien thong tin san phan tu nhieu bang voi dieu kien 56.76 < gia mua < 95.59
SELECT 
    productCode, productName, buyprice, textDescription
FROM
    products
        INNER JOIN
    productlines ON products.productline = productlines.productline
WHERE
    buyprice > 56.76 AND buyprice < 95.59;
    
-- hien thi san pham co loai la Classic Cars hoac nha cung cap la Min Lin Diecast
SELECT 
    productCode,
    productName,
    buyprice,
    quantityInStock,
    productVendor,
    productLine
FROM
    products
WHERE
    productLine = 'Classic Cars'
        OR productVendor = 'Min Lin Diecast'
