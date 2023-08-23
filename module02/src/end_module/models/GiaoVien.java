package end_module.models;

public class GiaoVien extends Person {
    private String maGiaoVien;
    private String tenGiaoVien;


    public GiaoVien() {
    }

    public GiaoVien(String ngaySinh, String gioiTinh, String soDienThoai, String maGiaoVien, String tenGiaoVien) {
        super(ngaySinh, gioiTinh, soDienThoai);
        this.maGiaoVien = maGiaoVien;
        this.tenGiaoVien = tenGiaoVien;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    @Override
    public String toString() {
        return "maGiaoVien= " + maGiaoVien + '\n' +
                "tenGiaoVien= " + tenGiaoVien + '\n' +
                "ngaySinh= " + this.getNgaySinh()+ '\n' +
                "gioiTinh= " + this.getGioiTinh() + '\n' +
                "soDienThoai= " + this.getSoDienThoai() + '\n' ;
    }
}
