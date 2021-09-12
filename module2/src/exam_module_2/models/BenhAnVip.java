package exam_module_2.models;

public class BenhAnVip extends BenhAn {
    private String goiVip;
    private String thoiHan;

    public BenhAnVip() {
    }

    public BenhAnVip(String goiVip, String thoiHan) {
        this.goiVip = goiVip;
        this.thoiHan = thoiHan;
    }

    public BenhAnVip(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String goiVip, String thoiHan) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo);
        this.goiVip = goiVip;
        this.thoiHan = thoiHan;
    }

    public String getGoiVip() {
        return goiVip;
    }

    public void setGoiVip(String goiVip) {
        this.goiVip = goiVip;
    }

    public String getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(String thoiHan) {
        this.thoiHan = thoiHan;
    }

    @Override
    public String toString() {
        return "BenhAnVip: " + super.toString() +
                ", goiVip='" + goiVip + '\'' +
                ", thoiHan='" + thoiHan;
    }
}
