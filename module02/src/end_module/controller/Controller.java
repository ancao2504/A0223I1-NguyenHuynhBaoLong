package end_module.controller;

import end_module.service.IServiceStudent;
import end_module.service.IServiceTeacher;
import end_module.service.impl.StudentServiceImpl;
import end_module.service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);
    private static IServiceStudent iServiceStudent = new StudentServiceImpl();
    private static IServiceTeacher iServiceTeacher = new TeacherServiceImpl();
    public static void mainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("-------------Quản lý sinh vien------------");
            System.out.println("1.Thêm  mới sinh viên");
            System.out.println("2.Xóa Sinh viên");
            System.out.println("3.Danh sách sinh viên");
            System.out.println("4.Xem Thông Tin Giáo Viên");
            System.out.println("5.Tìm kiếm Sinh viên");
            System.out.println("6.Thoát");
            System.out.println("--------------------------------");
            System.out.print("lựa chọn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("----------sai định dạng----------");
            }

            switch (choice) {
                case 1:
                    iServiceStudent.themMoi();
                    break;
                case 2:
                    iServiceStudent.xoaSinhvien();
                    break;
                case 3:
                    iServiceStudent.hienThi();
                    break;
                case 4:
                    iServiceTeacher.hienThiGiaoVien();
                    break;
                case 5:
                    iServiceStudent.timKiemSinhVien();
                    break;
                case 6:
                    check=false;
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1 tới 6");
                    break;
            }
        }
    }
}
