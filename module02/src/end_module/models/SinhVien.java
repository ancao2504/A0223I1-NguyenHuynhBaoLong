package end_module.models;

public class SinhVien extends Person {
    private String tenSinhVien;
    private int maSinhVien;
    private String maLophoc;

    public SinhVien() {
    }

    public SinhVien(String ngaySinh, String gioiTinh, String soDienThoai, String tenSinhVien, int maSinhVien, String maLophoc) {
        super(ngaySinh, gioiTinh, soDienThoai);
        this.tenSinhVien = tenSinhVien;
        this.maSinhVien = maSinhVien;
        this.maLophoc = maLophoc;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLophoc() {
        return maLophoc;
    }

    public void setMaLophoc(String maLophoc) {
        this.maLophoc = maLophoc;
    }

    @Override
    public String toString() {

        return
                "ngaySinh= " + this.getNgaySinh()+ '\n' +
                 "gioiTinh= " + this.getGioiTinh() + '\n' +
               "soDienThoai= " + this.getSoDienThoai() + '\n'+
                 "tenSinhVien= " + this.getTenSinhVien() + '\n' +
                "maSinhVien= " + this.getMaSinhVien() + '\n' +
                "maLophoc= " + this.getMaLophoc() + '\n';
    }
}
