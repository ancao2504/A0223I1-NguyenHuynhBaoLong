package CaseStudy.service.impl;


import CaseStudy.model.Employee;
import CaseStudy.repository.IRepository;
import CaseStudy.repository.impl.RepositoryEmployee;
import CaseStudy.service.IEmployeeService;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private List<Employee> listEmployee = new LinkedList<>();
    private IRepository iRepository = new RepositoryEmployee();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("------------Employee menu----------------------");
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employees");
            System.out.println("3.Edit employees");
            System.out.println("4.Return main menu");
            System.out.println("-----------------------------------------------");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    List<Employee> employeeList = iRepository.display();
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    iRepository.display();
                    break;
                case 2:
                    Employee employee = addEmployee();
                    iRepository.add(employee);
                    break;
                case 3:
                    List<Employee> list = iRepository.display();
                    System.out.print("Nhập tên nhân viên bạn muốn chỉnh sửa:");
                    String inputNameCheck = scanner.nextLine();
                    iRepository.edit(inputNameCheck);
                    break;
                case 4:
                    check = false;
                    break;

            }
        }
    }

    @Override
    public void editEmployee() {

    }


    public Employee addEmployee() {
        Employee employee = new Employee();
        System.out.print("NHập tên");
        employee.setName(scanner.nextLine());
        System.out.print("NHập ngày sinh");
        employee.setDateOfBirth(scanner.nextLine());
        System.out.print("NHập CMND");
        employee.setID(Long.parseLong(scanner.nextLine()));
        System.out.print("NHập mã");
        employee.setCode(Integer.parseInt(scanner.nextLine()));
        System.out.print("NHập giới tính");
        employee.setSex(scanner.nextLine());
        System.out.print("NHập số điện thoại");
        employee.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
        System.out.print("NHập email");
        employee.setEmail(scanner.nextLine());
        System.out.print("NHập trình độ");
        employee.setLevel(scanner.nextLine());
        System.out.print("NHập vị trí");
        employee.setNominee(scanner.nextLine());
        System.out.println("------------thêm mới thành công---------------");

        return employee;
    }
}
