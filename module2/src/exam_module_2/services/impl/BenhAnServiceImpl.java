package exam_module_2.services.impl;

import case_study.util.Validation;
import exam_module_2.models.BenhAn;
import exam_module_2.models.BenhAnThuong;
import exam_module_2.models.BenhAnVip;
import exam_module_2.util.ReadAndWrite;

import java.util.*;

public class BenhAnServiceImpl implements BenhAnService {
    private static final String REGEX_BA_ID = "(BA)[-][0-9]{3}";
    private static final String REGEX_BN_ID = "(BN)[-][0-9]{3}";
    private static final String REGEX_DATE = "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/([0-9][0-9])?[0-9][0-9]$";
    private final String path = "src\\exam_module_2\\data\\BenAn.csv";
    Scanner scanner = new Scanner(System.in);
    public static Map<BenhAn, Integer> benhAnIntegerMap = new LinkedHashMap();

    static {
        benhAnIntegerMap.put(new BenhAnThuong("BA-000", "BA-000", "Luan",
                "01/09/2021", "02/09/2021", "tach", 100), 1);
        benhAnIntegerMap.put(new BenhAnVip("BA-001", "BA-000", "Luan",
                "01/09/2021", "02/09/2021", "tach", "Vip I", "17/10/2021"), 2);
    }

    @Override
    public void display() {
        for (Map.Entry<BenhAn, Integer> benhAnThuong : benhAnIntegerMap.entrySet()) {
            System.out.println(benhAnThuong.getKey() + " - Stt: " + benhAnThuong.getValue());
        }
    }

    @Override
    public void addNew() {

    }

    public void themThuong() {
        System.out.println("Nhap stt: ");
        int stt = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ma benh an: ");
        String maBenhAn = checkMaBenhAn();
        System.out.println("Nhap ma benh nhan: ");
        String maBenhNhan = checkMaBenhNhan();
        System.out.println("Nhap ten benh nhan: ");
        String ten = scanner.nextLine();
        System.out.println("Nhap ngay vao vien: ");
        String ngayVao = checkNgay();
        System.out.println("Nhap ngay xuat vien: ");
        String ngayXuat = checkNgay();
        System.out.println("Nhap ly do: ");
        String lydo = scanner.nextLine();
        System.out.println("Nhap vien phi: ");
        double vienPhi = 0;
        try {
            vienPhi = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Vien phi phai la so!");
        }
        benhAnIntegerMap.put(new BenhAnThuong(maBenhAn, maBenhNhan, ten, ngayVao, ngayXuat, lydo, vienPhi), stt);
        writePatient(path);
        System.out.println("Them thanh cong!");
    }

    public void themVip() {
        System.out.println("Nhap stt: ");
        int stt = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ma benh an: ");
        String maBenhAn = checkMaBenhAn();
        System.out.println("Nhap ma benh nhan: ");
        String maBenhNhan = checkMaBenhNhan();
        System.out.println("Nhap ten benh nhan: ");
        String ten = scanner.nextLine();
        System.out.println("Nhap ngay vao vien: ");
        String ngayVao = checkNgay();
        System.out.println("Nhap ngay xuat vien: ");
        String ngayXuat = checkNgay();
        System.out.println("Nhap ly do: ");
        String lydo = scanner.nextLine();
        System.out.println("Nhap loai vip:\n1. vip 1 \n2. vip 2\n3. vip 3");
        String chon = scanner.nextLine();
        String loaiVip = "";
        if (chon.equals("1")) {
            loaiVip = "Vip I";
        } else if (chon.equals("2")) {
            loaiVip = "Vip II";
        } else if (chon.equals("3")) {
            loaiVip = "Vip 3";
        } else {
            System.out.println("Nhap sai!");
        }
        System.out.println("Nhap thoi han: ");
        String thoiHan = checkNgay();
        benhAnIntegerMap.put(new BenhAnVip(maBenhAn, maBenhNhan, ten, ngayVao, ngayXuat, lydo, loaiVip, thoiHan), stt);
        writePatient(path);
        System.out.println("Them thanh cong!");
    }


    @Override
    public void delete() {
        String ma;
        System.out.println("Nhap ma benh an can xoa: ");
        ma = scanner.nextLine();
        BenhAn benhAn = checkId(ma);
        benhAnIntegerMap.remove(benhAn);
    }

    public BenhAn checkId(String maBenhAn) {
        for (Map.Entry<BenhAn, Integer> benhAn : benhAnIntegerMap.entrySet()) {
            if (maBenhAn.equals(benhAn.getKey().getMaBenhNhan())) {
                return benhAn.getKey();
            }
        }
        return null;
    }

    private void writePatient(String path) {
        List<BenhAn> benhAns = new ArrayList<>();
        for (Map.Entry<BenhAn, Integer> benhAnIntegerEntry : benhAnIntegerMap.entrySet()) {
            benhAns.add(benhAnIntegerEntry.getKey());
        }
        ReadAndWrite.writeFile(benhAns, path);
    }

    private String checkMaBenhAn() {
        return Validation.checkInput(scanner.nextLine(), REGEX_BA_ID, "Dinh dang phai la BA-XXX!");
    }

    private String checkMaBenhNhan() {
        return Validation.checkInput(scanner.nextLine(), REGEX_BN_ID, "Dinh dang phai la BN-XXX!");
    }

    private String checkNgay() {
        return Validation.checkInput(scanner.nextLine(), REGEX_DATE, "Dinh dang phai la dd/mm/yyyy!");
    }
}
