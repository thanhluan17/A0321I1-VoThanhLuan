USE furama_resort;

-- 2. hien thi tt nhan vien co ten bat dau la 1 trong cac ky tu (H, T, K) va co toi da 15 ky tu
SELECT 
    *
FROM
    nhan_vien
WHERE
    SUBSTR(ho_ten, 1, 1) IN ('H' , 'T', 'K')
        AND LENGTH(ho_ten) <= 15;

-- 3. hien thi tt khach hang co do tuoi tu 18 - 50 va dia chi o Da Nang hoac Quang Tri
SELECT 
    *
FROM
    khach_hang
WHERE
    DATEDIFF(ngay_sinh, NOW())
        AND (dia_chi = 'Da Nang'
        OR dia_chi = 'Quang Tri');

-- 4. dem so lan dat phong cua khach hang Diamond va sap xep theo thu tu tang dan
SELECT 
    khach_hang.ho_ten, COUNT(hop_dong.id_hop_dong) AS so_lan_dat
FROM
    khach_hang
        INNER JOIN
    hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        INNER JOIN
    loai_khach ON khach_hang.id_loai_khach = loai_khach.id_loai_khach
WHERE
    ten_loai_khach = 'Diamond'
GROUP BY khach_hang.id_khach_hang
ORDER BY so_lan_dat;

-- 5. hien thi tt khach hang va tt hop dong, chi tiet hop dong cho cac khach hang da tung dat phong
SELECT 
    khach_hang.id_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.id_hop_dong,
    dich_vu.id_dich_vu,
    hop_dong.ngay_lam_hd,
    hop_dong.ngay_ket_thuc_hd,
    SUM(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) AS tong_tien
FROM
    khach_hang
        LEFT JOIN
    loai_khach ON khach_hang.id_loai_khach = loai_khach.id_loai_khach
        LEFT JOIN
    hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.id_dv_di_kem = dich_vu_di_kem.id_dv_di_kem
        LEFT JOIN
    dich_vu ON hop_dong.id_dich_vu = dich_vu.id_dich_vu
GROUP BY hop_dong.id_hop_dong;