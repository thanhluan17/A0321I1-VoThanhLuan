CREATE DATABASE furama_resort;
USE furama_resort;

CREATE TABLE loai_dich_vu (
    id_loai_dv INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai_dv VARCHAR(45) NOT NULL,
    CHECK (ten_loai_dv IN ('Villa' , 'House', 'Room'))
);

CREATE TABLE kieu_thue (
    id_kieu_thue INT AUTO_INCREMENT PRIMARY KEY,
    ten_kieu_thue VARCHAR(45) NOT NULL,
    CHECK (ten_kieu_thue IN ('Nam' , 'Thang', 'Ngay', 'Gio')),
    gia DOUBLE NOT NULL,
    CHECK (gia >= 0)
);

CREATE TABLE dich_vu (
    id_dich_vu INT AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu VARCHAR(45) NOT NULL,
    dien_tich INT,
    CHECK (dien_tich > 0),
    so_tang INT,
    CHECK (so_tang >= 0),
    so_nguoi_toi_da INT,
    CHECK (so_nguoi_toi_da > 0),
    chi_phi_thue DOUBLE,
    CHECK (chi_phi_thue >= 0),
    id_kieu_thue INT,
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue),
    id_loai_dv INT,
    FOREIGN KEY (id_loai_dv)
        REFERENCES loai_dich_vu (id_loai_dv),
    trang_thai VARCHAR(45)
);

CREATE TABLE loai_khach (
    id_loai_khach INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai_khach VARCHAR(45),
    CHECK (ten_loai_khach IN ('Diamond' , 'Platinium', 'Gold', 'Silver', 'Member'))
);

CREATE TABLE khach_hang (
    id_khach_hang INT AUTO_INCREMENT PRIMARY KEY,
    id_loai_khach INT,
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach),
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE,
    so_cmnd VARCHAR(15) NOT NULL,
    sdt CHAR(10) UNIQUE,
    email VARCHAR(45) UNIQUE,
    dia_chi VARCHAR(45)
);

CREATE TABLE dich_vu_di_kem (
    id_dv_di_kem INT AUTO_INCREMENT PRIMARY KEY,
    ten_dv_di_kem VARCHAR(45) NOT NULL,
    gia DOUBLE,
    CHECK (gia >= 0),
    don_vi INT,
    CHECK (don_vi >= 0),
    trang_thai_kha_dung VARCHAR(45)
);

CREATE TABLE vi_tri (
    id_vi_tri INT AUTO_INCREMENT PRIMARY KEY,
    ten_vi_tri VARCHAR(45) NOT NULL,
    CHECK (ten_vi_tri IN ('Le tan' , 'Phuc vu',
        'Chuyen vien',
        'Giam sat',
        'Quan ly',
        'Giam doc'))
);

CREATE TABLE trinh_do (
    id_trinh_do INT AUTO_INCREMENT PRIMARY KEY,
    ten_trinh_do VARCHAR(45) NOT NULL,
    CHECK (ten_trinh_do IN ('Trung cap' , 'Cao dang', 'Dai hoc', 'Sau dai hoc'))
);

CREATE TABLE bo_phan (
    id_bo_phan INT AUTO_INCREMENT PRIMARY KEY,
    ten_bo_phan VARCHAR(45) NOT NULL,
    CHECK (ten_bo_phan IN ('Sale - Marketing' , 'Hanh chinh', 'Phuc vu', 'Quan ly'))
);

CREATE TABLE nhan_vien (
    id_nhan_vien INT AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(45) NOT NULL,
    id_vi_tri INT,
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    id_trinh_do INT,
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    id_bo_phan INT,
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan),
    ngay_sinh DATE,
    so_cmnd VARCHAR(15) NOT NULL,
    luong DOUBLE,
    CHECK (luong >= 0),
    sdt CHAR(10) UNIQUE,
    email VARCHAR(45),
    dia_chi VARCHAR(45)
);

CREATE TABLE hop_dong (
    id_hop_dong INT AUTO_INCREMENT PRIMARY KEY,
    id_nhan_vien INT,
    FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien),
    id_khach_hang INT,
    FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang),
    id_dich_vu INT,
    FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu),
    ngay_lam_hd DATE NOT NULL,
    ngay_ket_thuc_hd DATE NOT NULL,
    CHECK (ngay_ket_thuc_hd >= ngay_lam_hd),
    tien_dat_coc DOUBLE,
    CHECK (tien_dat_coc >= 0),
    tong_tien DOUBLE,
    CHECK (tong_tien >= 0)
);

CREATE TABLE hop_dong_chi_tiet (
    id_hd_chi_tiet INT AUTO_INCREMENT PRIMARY KEY,
    id_hop_dong INT,
    FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong),
    id_dv_di_kem INT,
    FOREIGN KEY (id_dv_di_kem)
        REFERENCES dich_vu_di_kem (id_dv_di_kem),
    so_luong INT,
    CHECK (so_luong >= 0)
);

