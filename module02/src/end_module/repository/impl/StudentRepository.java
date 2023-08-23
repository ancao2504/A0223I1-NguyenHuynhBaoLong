package end_module.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import end_module.exception.NotFounStudentException;
import end_module.models.SinhVien;
import end_module.repository.IStudentRepository;

import java.util.*;


public class StudentRepository implements IStudentRepository{

    public static final String SRC_SINH_VIEN = "src/end_module/data/sinhVien.csv";
    private static Map<String,SinhVien> map = new HashMap<>();

    @Override
    public void themMoi(SinhVien sinhVien) {
        ReadAndWriteFile.writeFile(SRC_SINH_VIEN,convertToString(sinhVien),true);
        map.put(sinhVien.getSoDienThoai(),sinhVien);
    }

    @Override
    public List<SinhVien> hienThi() {
        List<SinhVien> sinhViens = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFile(SRC_SINH_VIEN);
        String[] temp = new String[0];
        for (String string : stringList) {
            temp = string.split(",");

            sinhViens.add(new SinhVien(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4]),temp[5]));
        }
        return sinhViens;
    }

    @Override
    public void xoaSinhVien(int maSinhVien) {
        List<SinhVien> list = hienThi();
        Boolean check =true;
        for (SinhVien sinhViens : list) {
            if (sinhViens.getMaSinhVien()== maSinhVien) {
                check=false;
                System.out.println("bạn muốn xóa sinh viên có mã: " + maSinhVien);
                System.out.println("1. Yes");
                System.out.println("2.No");
               int choice = Integer.parseInt(new Scanner(System.in).nextLine());
                if (choice == 1) {
                    list.remove(sinhViens);
                    String line = "";
                    for (SinhVien sinhVien : list) {
                        line += convertToString(sinhVien) + "\n";
                    }
                    line = line.substring(0, line.length() - 1);
                    ReadAndWriteFile.writeFile(SRC_SINH_VIEN, line, false);
                }
                break;
            }
        }
        try {
            if (check == true) {
                throw new NotFounStudentException("sinh viên không tồn tại");
            }
        } catch (NotFounStudentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void timKiem(String tenSinhVien) {
        List<SinhVien> list = hienThi();
        for (SinhVien sinhVien : list) {
            if (sinhVien.getTenSinhVien().equals(tenSinhVien)) {
                System.out.println(sinhVien.toString());
            }
        }
    }



    //String ngaySinh, String gioiTinh, String soDienThoai, String tenSinhVien, int maSinhVien, String maLophoc
    private String convertToString(SinhVien sinhVien) {
        return sinhVien.getNgaySinh() +"," + sinhVien.getGioiTinh() + "," + sinhVien.getSoDienThoai() +
                ","+sinhVien.getTenSinhVien() + "," +sinhVien.getMaSinhVien() + ","  + sinhVien.getMaLophoc();
    }
}
