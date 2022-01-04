USE furama_resort_db;

INSERT INTO position (position_name)
	VALUES('Le tan'),
		  ('Phuc vu'),
          ('Chuyen vien'),
          ('Giam sat'),
          ('Quan ly'),
          ('Giam doc');
          
INSERT INTO education_degree (education_degree_name)
	VALUES('Trung cap'),
		  ('Cao dang'),
          ('Dai hoc'),
          ('Sau dai hoc');
          
INSERT INTO division (division_name)
	VALUES('Sale - Marketing'),
		  ('Hanh chinh'),
          ('Phuc vu'),
          ('Quan ly');
          
INSERT INTO role (role_name)
	VALUES('ROLE_ADMIN'),
		  ('ROLE_USER'),	
		  ('ROLE_USER');

INSERT INTO user (username, password)
	VALUES('Admin', 'Admin'),
		  ('user001', '12345'),
		  ('user002', '12345'),
		  ('user003', '12345'),
		  ('user004', '12345'),
		  ('user005', '12345'),
		  ('user006', '12345'),
		  ('user007', '12345'),
		  ('user008', '12345'),
		  ('user009', '12345'),
		  ('user010', '12345'),
		  ('user011', '12345'),
		  ('user012', '12345'),
		  ('user013', '12345'),
		  ('user014', '12345');

INSERT INTO user_role (role_id, username)
	VALUES(1, 'Admin'),
		  (2, 'user001'),
		  (2, 'user002'),
		  (2, 'user003'),
		  (2, 'user004'),
		  (2, 'user005'),
		  (2, 'user006'),
		  (2, 'user007'),
		  (3, 'user008'),
		  (3, 'user009'),
		  (3, 'user010'),
		  (3, 'user011'),
		  (3, 'user012'),
		  (3, 'user013'),
		  (3, 'user014');

INSERT INTO employee(employee_name, position_id, education_degree_id, division_id, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, username)
	VALUES('Duong Van Duy', 1, 2, 3, '1993-12-21', '212464819', 7000000, '0381726351', 'duongduy99@gmail.com', 'Da Nang', 'user008'),
		  ('Tran Van Chien', 2, 1, 3, '1997-09-11', '212464881', 6000000, '0381771625', 'vanchien97@gmail.com', 'Quang Nam', 'user009'),
          ('Ho Thi Lan', 2, 1, 3, '1998-01-11', '212464888', 6500000, '0381726162', 'holan98@gmail.com', 'Hue', 'user010'),
          ('Vo Van Long', 3, 2, 2, '1994-02-20', '212464118', 9000000, '0381716254', 'vanlong17@gmail.com', 'Da Nang', 'user011'),
          ('Nguyen Duy Van', 4, 3, 4, '1997-07-07', '212464827', 9500000, '0381918271', 'vanduy11@gmail.com', 'Quang Tri', 'user012'),
          ('Doan Ngoc Nhi', 5, 3, 4, '1990-12-10', '212464800', 15000000, '0381069504', 'nhingoc18@gmail.com', 'Quang Ngai', 'user013'),
          ('Le Minh', 6, 4, 4, '1990-05-11', '212464893', 20000000, '0381171162', 'leminh99@gmail.com', 'Da Nang', 'user014');
          
INSERT INTO customer_type(customer_type_name)
	VALUES('Diamond'),
		  ('Platinium'),
          ('Gold'),
          ('Silver'),
          ('Member');
          
INSERT INTO customer(customer_type_id, customer_name, customer_birthday, customer_id_card, customer_phone, customer_email, customer_address, customer_gender)
	VALUES(1, 'Vo Thanh Luan', '2000-01-17', '212464739', '0383422211', 'thanhluan172@gmail.com', 'Quang Ngai', 1),
		  (1, 'Huynh Thanh Xuyen', '1994-07-01', '212464716', '0381723453', 'thanhxuyen11@gmail.com', 'Da Nang', 0),
		  (2, 'Tran Minh Khoa', '2003-05-11', '212464711', '0382716437', 'minhkhoa99@gmail.com', 'Vinh', 1),
          (3, 'Nguyen Van An', '1992-11-27', '212464790', '0371625341', 'vanan09@gmail.com', 'Quang Ngai', 1),
          (4, 'Tran Duc Chi', '2002-03-01', '212464788', '0301928172', 'ducchi01@gmail.com', 'Hue', 1),
          (5, 'Le Thi Ha', '2001-09-09', '212464791', '0351627183', 'hale37@gmail.com', 'Quang Nam', 0),
          (5, 'Bui Van Chung', '1999-12-12', '212464717', '0371827163', 'vanchung18@gmail.com', 'Quang Tri', 1);

INSERT INTO service_type(service_type_name)
	VALUES('Villa'), 
		  ('House'), 
          ('Room');
          
INSERT INTO rent_type(rent_type_name, rent_type_cost)
	VALUES('Nam', '10000000'),
		  ('Thang', 5000000),
          ('Ngay', 1000000),
          ('Gio', 500000);
          
INSERT INTO service(service_name, service_area, number_of_floor, service_max_people, service_cost, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area)
	VALUES('Villa Tran Hung Dao', 2000000, 3, 10, 350, 3, 1, '5 sao', 'Tot', '30'),
		  ('House Nha Trang', 170, 2, 7, 12000000, 2, 2, '4 sao', 'Tot', '30'),
          ('House Bana',250, 5, 15, 15000000, 1, 2, '3 sao', 'Tot', '30'),
          ('Room Cao Thang', 50, 1, 4, 500000, 4, 3, '4 sao', 'Tot', '30'),
          ('Villa Sa Huynh', 150, 1, 10, 5500000, 3, 1, '5 sao', 'Tot', '30');
          
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
	VALUES('Massage', 100000, 1, 'Kha dung'),
		  ('Karaoke', 200000, 10, 'Dung cung cap'),
          ('Thuc an', 50000, 1, 'Kha dung'),
          ('Nuoc uong', 100000, 6, 'Kha dung'),
          ('Thue xe', 1500000, 1, 'Kha dung');
          
INSERT INTO contract(employee_id, customer_id, service_id, contract_start_date, contract_end_date, contract_deposit)
	VALUES(1, 1, 1, '2019-02-17', '2019-03-17', 500000),
		  (2, 1, 3, '2019-03-17', '2019-04-17', 600000),
          (1, 3, 2, '2019-08-15', '2019-09-15', 700000),
          (1, 4, 4, '2019-03-17', '2019-04-17', 500000),
          (3, 5, 4, '2019-11-10', '2019-12-10', 500000),
          (4, 2, 3, '2019-11-10', '2019-12-10', 500000),
          (1, 1, 1, '2018-02-17', '2018-03-17', 500000),
          (1, 5, 3, '2018-02-17', '2018-03-17', 500000);
          
INSERT INTO contract_detail(contract_id, attach_service_id, quantity)
	VALUES(1, 1, 1),
		  (2, 2, 3),
          (3, 3, 2),
          (4, 4, 1),
          (5, 5, 3),
          (6, 2, 2),
          (7, 3, 2),
          (8, 2, 1);

