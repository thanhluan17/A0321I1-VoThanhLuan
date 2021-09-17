USE classicmodels;

-- tao procedure hien thi danh sach thong tin tat ca customer
DELIMITER //
CREATE PROCEDURE findAllCustomers()
BEGIN
  SELECT * FROM customers;
END //
DELIMITER ;

-- goi procedure de xem ket qua
CALL findAllCustomers();

-- xoa procedure va tao procedure moi cung ten
DELIMITER //
DROP PROCEDURE IF EXISTS `findAllCustomers`//

CREATE PROCEDURE findAllCustomers()
BEGIN
   SELECT *  FROM customers where customerNumber = 175;
END; //
DELIMITER ;

CALL findAllCustomers();