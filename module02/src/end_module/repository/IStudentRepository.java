package end_module.repository;

import end_module.models.SinhVien;

import java.util.List;

public interface IStudentRepository{
    void themMoi(SinhVien sinhVien);

    List<SinhVien> hienThi();

    void xoaSinhVien(int maSinhVien);

    void timKiem(String tenSinhVien);


}
