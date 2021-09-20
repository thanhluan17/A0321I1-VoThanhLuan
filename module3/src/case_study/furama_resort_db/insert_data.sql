USE furama_resort;

INSERT INTO loai_dich_vu(ten_loai_dv)
	VALUES('Villa'), 
		  ('House'), 
          ('Room');

INSERT INTO kieu_thue(ten_kieu_thue, gia)
	VALUES('Nam', '10000000'),
		  ('Thang', 5000000),
          ('Ngay', 1000000),
          ('Gio', 500000);

INSERT INTO dich_vu(ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dv, trang_thai)
	VALUES('Villa Tran Hung Dao', 2000000, 3, 10, 350, 3, 1, 'Da thue'),
		  ('House Nha Trang', 170, 2, 7, 12000000, 2, 2, 'Chua thue'),
          ('House Bana',250, 5, 15, 15000000, 1, 2, 'Da thue'),
          ('Room Cao Thang', 50, 1, 4, 500000, 4, 3, 'Chua thue'),
          ('Villa Sa Huynh', 150, 1, 10, 5500000, 3, 1, 'Da thue');

INSERT INTO loai_khach(ten_loai_khach)
	VALUES('Diamond'),
		  ('Platinium'),
          ('Gold'),
          ('Silver'),
          ('Member');

INSERT INTO khach_hang(id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi)
	VALUES(1, 'Vo Thanh Luan', '2000-01-17', '212464739', '0383422211', 'thanhluan172@gmail.com', 'Quang Ngai'),
		  (1, 'Huynh Thanh Xuyen', '1994-07-01', '212464716', '0381723453', 'thanhxuyen11@gmail.com', 'Da Nang'),
		  (2, 'Tran Minh Khoa', '2003-05-11', '212464711', '0382716437', 'minhkhoa99@gmail.com', 'Vinh'),
          (3, 'Nguyen Van An', '1992-11-27', '212464790', '0371625341', 'vanan09@gmail.com', 'Quang Ngai'),
          (4, 'Tran Duc Chi', '2002-03-01', '212464788', '0301928172', 'ducchi01@gmail.com', 'Hue'),
          (5, 'Le Thi Ha', '2001-09-09', '212464791', '0351627183', 'hale37@gmail.com', 'Quang Nam'),
          (5, 'Bui Van Chung', '1999-12-12', '212464717', '0371827163', 'vanchung18@gmail.com', 'Quang Tri');
          
INSERT INTO dich_vu_di_kem(ten_dv_di_kem, gia, don_vi, trang_thai_kha_dung)
	VALUES('Massage', 100000, 1, 'Kha dung'),
		  ('Karaoke', 200000, 10, 'Dung cung cap'),
          ('Thuc an', 50000, 1, 'Kha dung'),
          ('Nuoc uong', 100000, 6, 'Kha dung'),
          ('Thue xe', 1500000, 1, 'Kha dung');
          
INSERT INTO vi_tri(ten_vi_tri)
	VALUES('Le tan'),
		  ('Phuc vu'),
          ('Chuyen vien'),
          ('Giam sat'),
          ('Quan ly'),
          ('Giam doc');
          
INSERT INTO trinh_do(ten_trinh_do)
	VALUES('Trung cap'),
		  ('Cao dang'),
          ('Dai hoc'),
          ('Sau dai hoc');
          
INSERT INTO bo_phan(ten_bo_phan)
	VALUES('Sale - Marketing'),
		  ('Hanh chinh'),
          ('Phuc vu'),
          ('Quan ly');
          
INSERT INTO nhan_vien(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi)
	VALUES('Duong Van Duy', 1, 2, 3, '1993-12-21', '212464819', 7000000, '0381726351', 'duongduy99@gmail.com', 'Da Nang'),
		  ('Tran Van Chien', 2, 1, 3, '1997-09-11', '212464881', 6000000, '0381771625', 'vanchien97@gmail.com', 'Quang Nam'),
          ('Ho Thi Lan', 2, 1, 3, '1998-01-11', '212464888', 6500000, '0381726162', 'holan98@gmail.com', 'Hue'),
          ('Vo Van Long', 3, 2, 2, '1994-02-20', '212464118', 9000000, '0381716254', 'vanlong17@gmail.com', 'Da Nang'),
          ('Nguyen Duy Van', 4, 3, 4, '1997-07-07', '212464827', 9500000, '0381918271', 'vanduy11@gmail.com', 'Quang Tri'),
          ('Doan Ngoc Nhi', 5, 3, 4, '1990-12-10', '212464800', 15000000, '0381069504', 'nhingoc18@gmail.com', 'Quang Ngai'),
          ('Le Minh', 6, 4, 4, '1990-05-11', '212464893', 20000000, '0381171162', 'leminh99@gmail.com', 'Da Nang');
          
insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hd, ngay_ket_thuc_hd, tien_dat_coc)
	values(1, 1, 1, '2019-02-17', '2019-03-17', 500000),
		  (2, 1, 3, '2019-03-17', '2019-04-17', 600000),
          (1, 3, 2, '2019-08-15', '2019-09-15', 700000),
          (1, 4, 4, '2019-03-17', '2019-04-17', 500000),
          (3, 5, 4, '2019-11-10', '2019-12-10', 500000),
          (4, 2, 3, '2019-11-10', '2019-12-10', 500000);
    
insert into hop_dong_chi_tiet(id_hop_dong, id_dv_di_kem, so_luong)
	values(1, 1, 1),
		  (2, 2, 3),
          (3, 3, 2),
          (4, 4, 1),
          (5, 5, 3),
          (6, 2, 2);
		  
          
          
		