package CaseStudy.service.impl;


import CaseStudy.model.Employee;
import CaseStudy.repository.IRepositoryEmployee;
import CaseStudy.repository.impl.RepositoryEmployee;
import CaseStudy.service.IEmployeeService;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private List<Employee> listEmployee = new LinkedList<>();
    private IRepositoryEmployee iRepository = new RepositoryEmployee();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void menuOfEmployees() {
        Boolean check = true;
        while (check) {
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employees");
            System.out.println("3.Edit employees");
            System.out.println("4.Return main menu");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    List<Employee> employeeList = iRepository.displayListEmployee();
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    iRepository.displayListEmployee();
                    break;
                case 2:
                    Employee employee = addEmployee();
                    iRepository.addEmployee(employee);
                    break;
                case 4:
                    check=false;
                    break;
            }
        }
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

        return employee;
    }


//    public void displayListEmployee() {
//        li
//    }

}
