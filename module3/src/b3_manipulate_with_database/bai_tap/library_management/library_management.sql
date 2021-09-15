CREATE DATABASE library_management;

USE library_management;

CREATE TABLE the_loai (
    ma_loai INT AUTO_INCREMENT,
    PRIMARY KEY (ma_loai),
    ten_loai VARCHAR(50)
);

CREATE TABLE sach (
    ma_sach INT AUTO_INCREMENT,
    PRIMARY KEY (ma_sach),
    ten_sach VARCHAR(50) NOT NULL,
    nha_xb VARCHAR(50) NOT NULL,
    tac_gia VARCHAR(50) NOT NULL,
    nam_xb INT,
    so_lan_xb INT,
    gia DOUBLE,
    anh VARCHAR(50),
    ma_loai INT,
    FOREIGN KEY (ma_loai)
        REFERENCES the_loai (ma_loai)
);

CREATE TABLE sinh_vien (
    ma_sv INT AUTO_INCREMENT PRIMARY KEY,
    ten_sv VARCHAR(50) NOT NULL,
    dia_chi VARCHAR(500),
    email VARCHAR(50),
    hinh_anh VARCHAR(50)
);

CREATE TABLE phieu_muon (
    ma_sv INT,
    FOREIGN KEY (ma_sv)
        REFERENCES sinh_vien (ma_sv),
	ngay_dang_ky DATE NOT NULL,
    PRIMARY KEY (ma_sv , ngay_dang_ky),
    trang_thai CHAR(1) NULL CHECK (trang_thai IN ('M' , 'T', 'K'))
);

CREATE TABLE chi_tiet_phieu_muon (
    ma_sv INT,
    FOREIGN KEY (ma_sv)
        REFERENCES phieu_muon (ma_sv),
    ma_sach INT,
    FOREIGN KEY (ma_sach)
        REFERENCES sach (ma_sach),
    ngay_muon DATE NOT NULL,
    PRIMARY KEY (ma_sv , ma_sach),
    ngay_tra DATE NULL,
    CHECK (ngay_tra >= ngay_muon),
    ngay_thuc_tra DATE NULL,
    CHECK (ngay_thuc_tra >= ngay_muon),
    tinh_trang_muon VARCHAR(50),
    CHECK (tinh_trang_muon IN ('Qua han' , 'Hong sach', 'Mat sach', 'Binh thuong')),
    tien_phat DOUBLE NULL CHECK (tien_phat >= 0)
)
