package end_module.service.impl;

import end_module.exception.DateOfBirthException;
import end_module.exception.NameException;
import end_module.exception.PhoneException;
import end_module.models.SinhVien;
import end_module.repository.IStudentRepository;
import end_module.repository.impl.StudentRepository;
import end_module.service.IServiceStudent;

import java.util.*;

public class StudentServiceImpl implements IServiceStudent {
    private static Scanner scanner = new Scanner(System.in);
    private static List<SinhVien> danhSach = new ArrayList<>();
    private static IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void themMoi() {
        SinhVien sinhVien = thongTin();
        iStudentRepository.themMoi(sinhVien);
        System.out.println("---------------------thêm mới thành công-------------");
    }

    @Override
    public void hienThi() {
        danhSach = iStudentRepository.hienThi();
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }

    @Override
    public void xoaSinhvien() {
        System.out.print("mã sinh viên: ");
        int maSinhVien = Integer.parseInt(scanner.nextLine());
        iStudentRepository.xoaSinhVien(maSinhVien);
    }

    @Override
    public void timKiemSinhVien() {
        System.out.print("nhập mã sinh viên: ");
        String tenSinhVien = (scanner.nextLine());
        iStudentRepository.timKiem(tenSinhVien);
    }

    private SinhVien thongTin() {
        SinhVien sinhViens = new SinhVien();
        Boolean check = true;
        List<SinhVien> danhSachMoi = iStudentRepository.hienThi();
        if (danhSachMoi.isEmpty()) {
            sinhViens.setMaSinhVien(1);
        } else {
            sinhViens.setMaSinhVien(danhSachMoi.get(danhSachMoi.size() - 1).getMaSinhVien() + 1);
        }
        do {
            System.out.print("tên sinh viên: ");
            String tenSinhVien = scanner.nextLine();
            check = NameException.checkName(tenSinhVien);
            sinhViens.setTenSinhVien(tenSinhVien);
        } while (check == false);
        do {
            System.out.print("ngày sinh: ");
            String ngaySinh = scanner.nextLine();
            check = DateOfBirthException.checkDateOfBirth(ngaySinh);
            sinhViens.setNgaySinh(ngaySinh);
        } while (check == false);
        System.out.print("giới tính: ");
        sinhViens.setGioiTinh(scanner.nextLine());
        do {
            System.out.print("số điện thoại: ");
            String soDienThoai = (scanner.nextLine());
            check = PhoneException.checkPhoneNumber(soDienThoai);
            sinhViens.setSoDienThoai(soDienThoai);

        } while (check == false);
        System.out.print("mã lớp: ");
        sinhViens.setMaLophoc(scanner.nextLine());

        return sinhViens;
    }
}
