package end_module.models;

public class Lop {
    private String maLopHoc;
    private String tenLop;
    private String maGiaoVien;

    public Lop() {
    }

    public Lop(String maLopHoc, String tenLop, String maGiaoVien) {
        this.maLopHoc = maLopHoc;
        this.tenLop = tenLop;
        this.maGiaoVien = maGiaoVien;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Override
    public String toString() {
        return "maLopHoc= " + maLopHoc + '\n' +
                "tenLop= " + tenLop + '\n' +
                "maGiaoVien= " + maGiaoVien + '\n';
    }
}
