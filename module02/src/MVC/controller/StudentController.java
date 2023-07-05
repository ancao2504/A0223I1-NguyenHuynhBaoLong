package MVC.controller;

import MVC.service.IStudentService;
import MVC.service.impl.StudentService;


import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService iStudentService = new StudentService();
    public static void menu() {
        System.out.println("1.Thêm học sinh");
        System.out.println("2.Xóa học sinh");
        System.out.println("3.Hiển thị danh sách");
        int choise = Integer.parseInt(scanner.nextLine());
        switch (choise) {
            case 1:
                iStudentService.addStudent();
                break;
        }
    }
}
