CREATE DATABASE b5_demo;
USE b5_demo;

-- tao bang cho database b5_demo;
-- tao bang products
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    productPrice DOUBLE,
    productAmount INT,
    productDescription VARCHAR(200),
    productStatus VARCHAR(50)
);

-- chen du lieu cho database
insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values 	('07001', 'Dien thoai Iphone', 1000, 10, 'Dien thoai', 'new'),
		('07002', 'Tivi LG', 700, 7, 'Tivi', 'new'),
		('07003', 'Tu lanh Toshiba', 1100, 17, 'Tu lanh', 'new'),
		('07004', 'Laptop Asus', 1300, 9, 'Laptop', 'new');
        
-- tao unique index tren bang products va xem ket qua explain
CREATE UNIQUE INDEX index_productCode
ON products(productCode);

EXPLAIN SELECT * FROM products
WHERE productCode = '07003';

-- tao composite index
CREATE INDEX index_name_price
ON products(productName, productPrice);

EXPLAIN SELECT * FROM products 
WHERE productName = 'Ti vi LG' or productPrice = 700;

-- tao view lay ve mot so thong tin cua bang products
CREATE VIEW product_views AS
    SELECT 
        productCode, productName, productPrice, productStatus
    FROM
        products;

-- xem ket qua tu view da tao
SELECT 
    *
FROM
    product_views;
    
-- sua view vua tao
CREATE OR REPLACE VIEW product_views AS
    SELECT 
        productCode, productName, productPrice, productStatus
    FROM
        products
    WHERE
        productPrice > 1000;

-- xem lai ket qua view vua sua
SELECT 
    *
FROM
    product_views;
    
-- xoa view bang drop
DROP VIEW product_views;

-- tao procedure
-- procedure lay tat ca thong tin cua san pham
DELIMITER //
CREATE PROCEDURE findAllProducts()
BEGIN
  SELECT * FROM products;
END //
DELIMITER ;

CALL findAllProducts();

-- procedure them mot san pham moi
DELIMITER //
CREATE PROCEDURE addNewProducts(
	IN productCode varchar(50), 
	IN productName varchar(50), 
	IN productPrice double, 
	In productAmount int, 
	IN productDescription varchar(50), 
	IN productStatus varchar(50)
)
BEGIN
  insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
  values (productCode, productName, productPrice, productAmount, productDescription, productStatus);
END //
DELIMITER ;

CALL addNewProducts('07005', 'Tablet Xiaomi', 1500, 5, 'Tablet', 'new');
SELECT 
    *
FROM
    products;
    
-- procedure sua thong tin san pham theo id
DELIMITER //
CREATE PROCEDURE editProducts(
	IN editId int,
	IN newProductCode varchar(50), 
	IN newProductName varchar(50), 
	IN newProductPrice double, 
	In newProductAmount int, 
	IN newProductDescription varchar(50), 
	IN newProductStatus varchar(50)
)
BEGIN
  UPDATE products
	SET 
		productCode = newProductCode,
		productName = newProductName,
		productPrice = newProductPrice,
		productAmount = newProductAmount,
		productDescription = newProductDescription,
		productStatus = newProductStatus
	WHERE id = editId;
END //
DELIMITER ;

CALL editProducts(5, '07007', 'Tablet SamSung', 1400, 10, 'Tablet', 'new');
SELECT 
    *
FROM
    products;
    
-- procedure xoa san pham theo id
DELIMITER //
CREATE PROCEDURE deleteProducts(
	IN deleteID int
)
BEGIN
  DELETE FROM products
	WHERE id = deleteId;
END //
DELIMITER ;

CALL deleteProducts(5);
SELECT 
    *
FROM
    products;