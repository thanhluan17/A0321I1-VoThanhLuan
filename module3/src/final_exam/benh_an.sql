create DATABASE benh_an_db;
use benh_an_db;

CREATE TABLE benh_nhan (
    ma_benh_nhan INT AUTO_INCREMENT PRIMARY KEY,
    ten_benh_nhan VARCHAR(50)
);

CREATE TABLE benh_an (
    ma_benh_an INT AUTO_INCREMENT PRIMARY KEY,
    ma_benh_nhan INT,
    FOREIGN KEY (ma_benh_nhan)
        REFERENCES benh_nhan (ma_benh_nhan),
    ngay_nhap_vien DATE,
    ngay_ra_vien DATE,
    ly_do VARCHAR(50)
);

insert into benh_nhan(ten_benh_nhan)
	VALUES('Võ Thành Luân'),
		  ('Trần Minh Khoa'),
		  ('Huỳnh Thanh Xuyến'),
		  ('Nguyễn Văn Nam'),
		  ('Lê Anh Đức');
          
insert into benh_an(ma_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do)
	VALUES(1, '2021-11-01', '2021-11-02', 'Shock'),
		  (2, '2021-11-01', '2021-11-03', 'Đau tim'),
		  (3, '2021-10-31', '2021-11-02', 'Đau đầu'),
		  (4, '2021-10-29', '2021-11-05', 'Đau tim'),
		  (5, '2021-10-30', '2021-11-04', 'Tai nạn');
          
          
          