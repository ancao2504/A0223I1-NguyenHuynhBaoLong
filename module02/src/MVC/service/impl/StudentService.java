package MVC.service.impl;

import MVC.model.Student;
import MVC.repository.IStudentRepository;
import MVC.repository.impl.StudentRepository;
import MVC.service.IStudentService;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private Scanner scanner = new Scanner(System.in);
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void addStudent() {
        Student student=InforStudent();
         iStudentRepository.addStudent(student);
    }

    public Student InforStudent() {
        Student student = new Student();
        System.out.print("Nhập mã số");
        student.setCode(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên sinh viên");
        student.setName(scanner.nextLine());
        System.out.print("Nhập ngày sinh");
        student.setDateOfBirth(scanner.nextLine());
        System.out.print("Nhập lớp");
        student.setGrade(Double.parseDouble(scanner.nextLine()));
        return student;
    }
}
