CREATE database common_function;
USE common_function;

-- tao bang
CREATE TABLE sinh_vien (
    id INT,
    ten VARCHAR(50) NOT NULL,
    tuoi INT,
    khoa VARCHAR(50),
    so_tien DOUBLE
);

-- nhap du lieu
insert into sinh_vien
values 	(1, 'Hoang', 21, 'CNTT', 400000),
		(2, 'Viet', 19, 'DTVT', 320000),
		(3, 'Thanh', 18, 'KTDN', 400000),
		(4, 'Nhan', 19, 'CK', 450000),
		(5, 'Huong', 20, 'TCNH', 500000),
		(5, 'Huong', 20, 'TCNH', 200000);

-- hien thi tat ca cac dong co ten la huong
SELECT 
    *
FROM
    sinh_vien
WHERE
    ten = 'Huong';
    
-- hien thi tong so tien cua Huong
SELECT 
    SUM(so_tien)
FROM
    sinh_vien
WHERE
    ten = 'Huong';
    
-- hien thi danh sach ten cua tat ca hoc vien (khong trung lap)
SELECT 
    ten
FROM
    sinh_vien
GROUP BY (ten);