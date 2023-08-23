package end_module.models;

public abstract class Person {
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;

    public Person(String ngaySinh, String gioiTinh, String soDienThoai) {
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
    }

    public Person() {
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return  "ngaySinh= " + ngaySinh + '\n' +
                "gioiTinh= " + gioiTinh + '\n' +
                "soDienThoai= " + soDienThoai + '\n' ;
    }
}
