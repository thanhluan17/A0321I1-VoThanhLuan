package exam_module_2.services.impl;

import exam_module_2.models.BenhAn;
import exam_module_2.models.BenhAnThuong;
import exam_module_2.models.BenhAnVip;
import exam_module_2.util.ReadAndWrite;

import java.util.*;

public class BenhAnThuongServiceImpl implements BenhAnThuongService {
    private final String path = "src\\exam_module_2\\data\\BenAn.csv";
    Scanner scanner = new Scanner(System.in);
    public static Map<BenhAn, Integer> benhAnIntegerMap = new LinkedHashMap();

    static {
        benhAnIntegerMap.put(new BenhAnThuong("001", "001", "Luan",
                "01/09/2021", "02/09/2021", "tach", 100), 1);
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
        int stt = 0;
        System.out.println("Nhap ma benh an: ");
        String maBenhAn = scanner.nextLine();
        System.out.println("Nhap ma benh nhan: ");
        String maBenhNhan = scanner.nextLine();
        System.out.println("Nhap ten benh nhan: ");
        String ten = scanner.nextLine();
        System.out.println("Nhap ngay vao vien: ");
        String ngayVao = scanner.nextLine();
        System.out.println("Nhap ngay xuat vien: ");
        String ngayXuat = scanner.nextLine();
        System.out.println("Nhap ly do: ");
        String lydo = scanner.nextLine();
        System.out.println("Nhap vien phi: ");
        double vienPhi = Double.parseDouble(scanner.nextLine());
        benhAnIntegerMap.put(new BenhAnThuong(maBenhAn, maBenhNhan, ten, ngayVao, ngayXuat, lydo, vienPhi), stt + 1);
        System.out.println("Them thanh cong!");
    }

    public void themVip() {
        int stt = 0;
        System.out.println("Nhap ma benh an: ");
        String maBenhAn = scanner.nextLine();
        System.out.println("Nhap ma benh nhan: ");
        String maBenhNhan = scanner.nextLine();
        System.out.println("Nhap ten benh nhan: ");
        String ten = scanner.nextLine();
        System.out.println("Nhap ngay vao vien: ");
        String ngayVao = scanner.nextLine();
        System.out.println("Nhap ngay xuat vien: ");
        String ngayXuat = scanner.nextLine();
        System.out.println("Nhap ly do: ");
        String lydo = scanner.nextLine();
        System.out.println("Nhap loai vip: ");
        String loaiVip = scanner.nextLine();
        System.out.println("Nhap thoi han: ");
        String thoiHan = scanner.nextLine();
        benhAnIntegerMap.put(new BenhAnVip(maBenhAn, maBenhNhan, ten, ngayVao, ngayXuat, lydo, loaiVip, thoiHan), stt + 1);
        writePatient(path);
        System.out.println("Them thanh cong!");
    }


    @Override
    public void delete() {
        String ma;
        do {
            System.out.println("Nhap ma benh an can xoa: ");
            ma = scanner.nextLine();
            if (checkId(ma) == null) {
                System.out.println("Khong tim thay ma ben an!Nhap lai: ");
            }
        } while (checkId(ma) != null);

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
}
