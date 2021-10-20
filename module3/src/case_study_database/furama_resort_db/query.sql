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

-- 6. hien thi thong tin dich vu chua tung duoc thue tu quy 1 nam 2019
SELECT 
    dich_vu.id_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dv
FROM
    dich_vu
        INNER JOIN
    loai_dich_vu ON dich_vu.id_loai_dv = loai_dich_vu.id_loai_dv
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            hop_dong
        WHERE
            (hop_dong.ngay_lam_hd BETWEEN '2019-01-01' AND '2019-03-31')
                AND hop_dong.id_dich_vu = dich_vu.id_dich_vu);

-- 7. hien thi thong tin dich vu cua cac loai dich vu da duoc thue trong nam 2018 nhung k duoc thue trong nam 2019
SELECT 
    dich_vu.id_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.so_nguoi_toi_da,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dv
FROM
    dich_vu
        INNER JOIN
    loai_dich_vu ON dich_vu.id_loai_dv = loai_dich_vu.id_loai_dv
WHERE
    EXISTS( SELECT 
            hop_dong.id_hop_dong
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hd) = '2018'
                AND hop_dong.id_dich_vu = dich_vu.id_dich_vu)
        AND NOT EXISTS( SELECT 
            hop_dong.id_hop_dong
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hd) = '2019'
                AND hop_dong.id_dich_vu = dich_vu.id_dich_vu);
                
-- 8. hien thi ho ten khach hang khong trung nhau co trong he thong 
-- cach 1
SELECT DISTINCT
    khach_hang.ho_ten
FROM
    khach_hang;
-- cach 2
SELECT 
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten;
-- cach 3
SELECT 
    ho_ten
FROM
    khach_hang 
UNION SELECT 
    ho_ten
FROM
    khach_hang;
    
-- 9. thong ke doanh thu theo thang trong nam 2019
SELECT 
    temp.month,
    COUNT(MONTH(hop_dong.ngay_lam_hd)) AS so_kh_dk,
    SUM(hop_dong.tong_tien) AS tong_tien
FROM
    (SELECT 1 AS month UNION SELECT 2 AS month UNION SELECT 3 AS month UNION SELECT 4 AS month UNION SELECT 5 AS month UNION SELECT 6 AS month UNION SELECT 7 AS month UNION SELECT 8 AS month UNION SELECT 9 AS month UNION SELECT 10 AS month UNION SELECT 11 AS month UNION SELECT 12 AS month) AS temp
        LEFT JOIN
    hop_dong ON MONTH(hop_dong.ngay_lam_hd) = temp.month
        LEFT JOIN
    khach_hang ON khach_hang.id_khach_hang = hop_dong.id_hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hd) = '2019'
        OR YEAR(hop_dong.ngay_lam_hd) IS NULL
        OR MONTH(hop_dong.ngay_lam_hd) IS NULL
GROUP BY temp.month;

-- 10. hien thi tt hop dong da su dung bao nhieu dich vu di kem
SELECT 
    hop_dong.id_hop_dong,
    hop_dong.ngay_lam_hd,
    hop_dong.ngay_ket_thuc_hd,
    hop_dong.tien_dat_coc,
    COUNT(hop_dong_chi_tiet.id_hd_chi_tiet) AS sl_dv
FROM
    hop_dong
        INNER JOIN
    hop_dong_chi_tiet ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
GROUP BY hop_dong.id_hop_dong;

-- 11. hien thi thong tin dich vu di kem dc su dung boi khach hang Diamond va co dia chi la Vinh hoac Quang Ngai
SELECT 
    dich_vu_di_kem.*
FROM
    dich_vu_di_kem
        INNER JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.id_dv_di_kem = hop_dong_chi_tiet.id_dv_di_kem
        INNER JOIN
    hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        INNER JOIN
    khach_hang ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
        INNER JOIN
    loai_khach ON khach_hang.id_loai_khach = loai_khach.id_loai_khach
WHERE
    loai_khach.ten_loai_khach = 'Diamond'
        AND (khach_hang.dia_chi = 'Vinh'
        OR khach_hang.dia_chi = 'Quang Ngai');
        
-- 12. hien thi thong tin hop dong chi tiet da duoc khach hang dat vao 3 thang cuoi 2019 nhung chua tung duoc dat vao 6 thang dau
SELECT 
    hop_dong.id_hop_dong,
    hop_dong.tong_tien,
    hop_dong.tien_dat_coc,
    nhan_vien.ho_ten,
    khach_hang.ho_ten,
    khach_hang.sdt,
    dich_vu.ten_dich_vu,
    COUNT(hop_dong_chi_tiet.id_dv_di_kem) AS so_lan_sd
FROM
    hop_dong inner join nhan_vien on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien 
    inner join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
    inner join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
    where not exists (select hop_dong.id_hop_dong where hop_dong.ngay_lam_hd between '2019-01-01' and '2019-06-31')
    and exists (select hop_dong.id_hop_dong where hop_dong.ngay_lam_hd between '2019-09-01' and '2019-12-31');
    
-- 13. hien thi cac dich vu di kem duoc su dung nhieu nhat
SELECT 
    dich_vu_di_kem.ten_dv_di_kem,
    COUNT(hop_dong_chi_tiet.id_dv_di_kem) AS sl_su_dung
FROM
    dich_vu_di_kem
        INNER JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.id_dv_di_kem = hop_dong_chi_tiet.id_dv_di_kem
GROUP BY hop_dong_chi_tiet.id_dv_di_kem
HAVING sl_su_dung = (SELECT 
        COUNT(hop_dong_chi_tiet.id_dv_di_kem) AS sl
    FROM
        dich_vu_di_kem
            INNER JOIN
        hop_dong_chi_tiet ON dich_vu_di_kem.id_dv_di_kem = hop_dong_chi_tiet.id_dv_di_kem
    GROUP BY hop_dong_chi_tiet.id_dv_di_kem
    ORDER BY sl DESC
    LIMIT 1);

-- 14. hien thi thong tin dich vu di kem chi moi duoc su dung 1 lan duy nhat
SELECT 
    hop_dong_chi_tiet.id_hop_dong,
    loai_dich_vu.ten_loai_dv,
    dich_vu_di_kem.ten_dv_di_kem,
    COUNT(hop_dong_chi_tiet.id_hd_chi_tiet) AS sl_su_dung
FROM
    dich_vu_di_kem
        INNER JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.id_dv_di_kem = hop_dong_chi_tiet.id_dv_di_kem
        INNER JOIN
    hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        INNER JOIN
    dich_vu ON hop_dong.id_dich_vu = dich_vu.id_dich_vu
        INNER JOIN
    loai_dich_vu ON dich_vu.id_loai_dv = loai_dich_vu.id_loai_dv
GROUP BY hop_dong_chi_tiet.id_dv_di_kem
HAVING sl_su_dung = 1;

-- 15. hien thi thong tin nhan vien moi chi lap duoc toi da 3 hop dong tu nam 2018 - 2019
SELECT 
    nhan_vien.id_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.sdt,
    nhan_vien.dia_chi,
    COUNT(hop_dong.id_hop_dong) AS so_hd
FROM
    nhan_vien
        INNER JOIN
    hop_dong ON nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
        INNER JOIN
    trinh_do ON nhan_vien.id_trinh_do = trinh_do.id_trinh_do
        INNER JOIN
    bo_phan ON nhan_vien.id_bo_phan = bo_phan.id_bo_phan
WHERE
    YEAR(hop_dong.ngay_lam_hd) BETWEEN '2018' AND '2019'
GROUP BY hop_dong.id_nhan_vien
HAVING so_hd <= 3;

-- 16. xoa nhan vien chua tung lap hop dong nao tu nam 2017 - 2019
DELETE FROM nhan_vien 
WHERE
    nhan_vien.id_nhan_vien NOT IN (SELECT 
        *
    FROM
        (SELECT DISTINCT
            nhan_vien.id_nhan_vien
        FROM
            hop_dong
        INNER JOIN nhan_vien ON hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
        
        WHERE
            YEAR(hop_dong.ngay_lam_hd) BETWEEN '2017' AND '2019') AS temp);

-- 17. cap nhat thong tin khach hang Platinium thanh Diamond voi nhung khach da thanh toan trong nam 2019 lon hon 10tr
UPDATE khach_hang 
SET 
    khach_hang.id_loai_khach = 1
WHERE
    khach_hang.id_khach_hang IN (SELECT 
            t.id_khach_hang
        FROM
            (SELECT 
                khach_hang.id_khach_hang, SUM(hop_dong.tong_tien) AS tong
            FROM
                khach_hang
            INNER JOIN hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
            WHERE
                khach_hang.id_loai_khach = 2
                    AND YEAR(hop_dong.ngay_lam_hd) = 2019
            GROUP BY hop_dong.id_khach_hang
            HAVING tong >= 1000000) AS t);
            
-- 18. xoa khach hang co hop dong truoc nam 2016
SET FOREIGN_KEY_CHECKS=0;
DELETE FROM khach_hang 
WHERE
    khach_hang.id_khach_hang IN (SELECT 
        *
    FROM
        (SELECT DISTINCT
            khach_hang.id_khach_hang
        FROM
            khach_hang
        INNER JOIN hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        
        WHERE
            hop_dong.ngay_lam_hd < '2016-12-31') AS temp)
    AND khach_hang.id_khach_hang NOT IN (SELECT 
        *
    FROM
        (SELECT DISTINCT
            khach_hang.id_khach_hang
        FROM
            khach_hang
        INNER JOIN hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        
        WHERE
            hop_dong.ngay_lam_hd > '2016-12-31') AS temp);
SET FOREIGN_KEY_CHECKS=1;

-- 19. cap nhat gia dv di kem duoc su dung tren 10 lan
UPDATE dich_vu_di_kem 
SET 
    dich_vu_di_kem.gia = (dich_vu_di_kem.gia * 10)
WHERE
    dich_vu_di_kem.id_dv_di_kem IN (SELECT 
            temp.id_dv_di_kem
        FROM
            (SELECT 
                dich_vu_di_kem.id_dv_di_kem,
                    SUM(hop_dong_chi_tiet.so_luong) AS so_lan
            FROM
                dich_vu_di_kem
            INNER JOIN hop_dong_chi_tiet ON dich_vu_di_kem.id_dv_di_kem = hop_dong_chi_tiet.id_dv_di_kem
            GROUP BY hop_dong_chi_tiet.id_dv_di_kem
            HAVING so_lan > 10) AS temp);

-- 20. hien thi thong tin tat ca nhan vien va khach hang co trong he thong
SELECT 
    nhan_vien.id_nhan_vien AS id,
    nhan_vien.ho_ten,
    nhan_vien.email,
    nhan_vien.sdt,
    nhan_vien.ngay_sinh,
    nhan_vien.dia_chi,
    'nv' AS loai
FROM
    nhan_vien 
UNION SELECT 
    khach_hang.id_khach_hang AS id,
    khach_hang.ho_ten,
    khach_hang.email,
    khach_hang.sdt,
    khach_hang.ngay_sinh,
    khach_hang.dia_chi,
    'kh' AS loai
FROM
    khach_hang;
    
-- 21. tao khung nhin lay thong tin cac nhan vien co dia chi la Hai Chau va tung lap 1 hoac nhieu hop dong voi ngay lam hop dong la 12/12/2019
CREATE VIEW V_NHANVIEN AS
    SELECT 
        nhan_vien.*
    FROM
        nhan_vien
            INNER JOIN
        hop_dong ON nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
    WHERE
        nhan_vien.dia_chi = 'Hai Chau'
            AND hop_dong.ngay_lam_hd = '2019-12-12';

-- 22. cap nhat dia chi cua nhan vien trong trong V_NHANVIEN thanh Lien Chieu
UPDATE V_NHANVIEN 
SET 
    dia_chi = 'Lien Chieu';
    
-- 23. tao procedure de xoa thong tin cua 1 khach hang 
	-- set on delete cascade cho cac khoa ngoai
ALTER TABLE hop_dong DROP FOREIGN KEY `hop_dong_ibfk_2`;
ALTER TABLE hop_dong_chi_tiet DROP FOREIGN KEY `hop_dong_chi_tiet_ibfk_1`;
SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE hop_dong ADD CONSTRAINT `hop_dong_ibfk_2` FOREIGN KEY (id_khach_hang)
    REFERENCES khach_hang (id_khach_hang) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE hop_dong_chi_tiet ADD CONSTRAINT `hop_dong_chi_tiet_ibfk_1` FOREIGN KEY (id_hop_dong)
    REFERENCES hop_dong (id_hop_dong) ON UPDATE CASCADE ON DELETE CASCADE;
SET FOREIGN_KEY_CHECKS=1;

	-- tao procedure
DELIMITER //
CREATE PROCEDURE Sp_1(
	IN id int
)
BEGIN
  delete from khach_hang where khach_hang.id_khach_hang = id;
END //
DELIMITER ;
	-- goi procedure
CALL Sp_1(4);

-- 24. tao procedure dung de them moi hop dong
DELIMITER //
CREATE PROCEDURE Sp_2(
	IN id_nv int,
	IN id_kh int,
	IN id_dv int,
    IN ngay_lam_hd date,
    IN ngay_ket_thuc date,
    IN tien_coc double,
    IN tong_tien double
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
	GET DIAGNOSTICS condition 1
			@SQLState = RETURNED_SQLSTATE, @SQLMessage = MESSAGE_TEXT; 
			SELECT CONCAT('Database error occurred, state - ',@SQLState, '; error msg - ', @SQLMessage) As errorString; 
  insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hd, ngay_ket_thuc_hd, tien_dat_coc, tong_tien)
  value(id_nv, id_kh, id_dv, ngay_lam_hd, ngay_ket_thuc, tien_coc, tong_tien);
END //
DELIMITER ;
CALL Sp_2(1, 4, 1, '2019-07-07', '2019-09-07', 1000000, 5000000);

-- 25. tao trigger khi xoa ban ghi trong hop dong thi hien thi tong so luong ban ghi con lai ra man hinh console
DELIMITER $$
CREATE TRIGGER Tr_1
    AFTER DELETE
    ON hop_dong FOR EACH ROW
BEGIN
  SET @record_count = (SELECT count(hop_dong.id_hop_dong) from hop_dong);
END$$
DELIMITER ;

DELETE FROM hop_dong 
WHERE
    hop_dong.id_hop_dong = 9;
SELECT @record_count
