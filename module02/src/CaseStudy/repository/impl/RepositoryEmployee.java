package CaseStudy.repository.impl;

import CaseStudy.model.Employee;
import CaseStudy.repository.IRepositoryEmployee;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RepositoryEmployee implements IRepositoryEmployee {
    private static final List<Employee> employeeList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);
    static {
        employeeList.add(new Employee("long","12/12/12222","NAM",12,1222,"asda@",1,"ád","ád "));
        employeeList.add(new Employee("bl","12/12/12","nam",12,112,"asadda@",12,"á2d","ád"));
        employeeList.add(new Employee("d","12/12/12","nam",12,1,"asda@",123,"á23d","ád"));
    }


    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<Employee> display() {
        return employeeList;
    }

    @Override
    public void edit(String inputNameCheck) {
        for (Employee employee: employeeList) {
            if (inputNameCheck.equals(employee.getName())) {
                System.out.println(employee.toString());
                System.out.println("bạn muốn thay đổi thông tin nào:");
                System.out.println("1.Tên");
                System.out.println("2.Số điện thoại");
                System.out.println("3.Email");
                System.out.println("4.Giới tính");
                System.out.println("5.Ngày sinh");
                System.out.println("6.CCCD");
                System.out.println("7.Mã");
                System.out.println("8.Trình độ");
                System.out.println("9.Vị trí");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.print("Nhập tên mới:");
                        String name= scanner.nextLine();
                        employee.setName(name);
                        break;
                    case 2:
                        System.out.print("Nhập SĐT mới:");
                        int phone= Integer.parseInt(scanner.nextLine());
                        employee.setPhoneNumber(phone);
                        break;
                    case 3:
                        System.out.print("Nhập Email mới:");
                        String email= scanner.nextLine();
                        employee.setEmail(email);
                        break;
                    case 4:
                        System.out.print("Nhập giới tính:");
                        String sex= scanner.nextLine();
                        employee.setSex(sex);
                        break;
                    case 5:
                        System.out.print("Nhập ngày sinh:");
                        String dateOfBirth= scanner.nextLine();
                        employee.setDateOfBirth(dateOfBirth);
                        break;
                    case 6:
                        System.out.print("Nhập CCCD:");
                        long ID= Long.parseLong(scanner.nextLine());
                        employee.setID(ID);
                        break;
                    case 7:
                        System.out.print("Nhập Mã:");
                        int code= Integer.parseInt(scanner.nextLine());
                        employee.setCode(code);
                        break;
                    case 8:
                        System.out.print("Nhập trình độ:");
                        String level= scanner.nextLine();
                        employee.setLevel(level);
                        break;
                    case 9:
                        System.out.print("Nhập vị trí:");
                        String nominee= scanner.nextLine();
                        employee.setNominee(nominee);
                        break;
                }
            }else {
                System.out.println("Không tìm thấy tên!!");
                break;
            }
        }
    }

}
