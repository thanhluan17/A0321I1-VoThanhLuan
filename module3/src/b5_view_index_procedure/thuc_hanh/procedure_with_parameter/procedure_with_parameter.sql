USE classicmodels;

-- procedure voi tham so loai IN
DELIMITER //
CREATE PROCEDURE getCusById(IN cusNum INT(11))
BEGIN
  SELECT * FROM customers WHERE customerNumber = cusNum;
END //
DELIMITER ;

-- goi procedure va truyen tham so customerNumber = 175;
CALL getCusById(175);

-- procedure voi tham so loai OUT
DELIMITER //
CREATE PROCEDURE GetCustomersCountByCity(
    IN  in_city VARCHAR(50),
    OUT total INT
)
BEGIN
    SELECT COUNT(customerNumber)
    INTO total
    FROM customers
    WHERE city = in_city;
END//
DELIMITER ;

-- goi procedure va xem ket qua o tham so OUT
CALL GetCustomersCountByCity('Lyon',@total);
SELECT @total;

-- procedure voi tham so loai INOUT
DELIMITER //
CREATE PROCEDURE SetCounter(
    INOUT counter INT,
    IN inc INT
)
BEGIN
    SET counter = counter + inc;
END//
DELIMITER ;

-- goi procedure
SET @counter = 1;
CALL SetCounter(@counter,1); -- 2
CALL SetCounter(@counter,1); -- 3
CALL SetCounter(@counter,5);-- 8
SELECT @counter; -- 8