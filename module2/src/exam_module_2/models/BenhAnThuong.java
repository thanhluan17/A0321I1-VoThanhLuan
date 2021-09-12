package exam_module_2.models;

public class BenhAnThuong extends BenhAn {
    private double vienPhi;

    public BenhAnThuong() {
    }

    public BenhAnThuong(double vienPhi) {
        this.vienPhi = vienPhi;
    }

    public BenhAnThuong(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, double vienPhi) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo);
        this.vienPhi = vienPhi;
    }

    public double getVienPhi() {
        return vienPhi;
    }

    public void setVienPhi(double vienPhi) {
        this.vienPhi = vienPhi;
    }

    @Override
    public String toString() {
        return "BenhAnThuong: " + super.toString() + ", vienPhi=" + vienPhi;
    }
}
