package CaseStudy.service.impl;

import CaseStudy.Exception.CodeEmployeeException;
import CaseStudy.Exception.IDEmployeeException;
import CaseStudy.Exception.NameException;
import CaseStudy.model.Employee;
import CaseStudy.repository.IEmployeeRepository;
import CaseStudy.repository.impl.EmployeeRepository;
import CaseStudy.service.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    public void employeeMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("------------Employee Menu-----------");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Search by name employee");
            System.out.println("6. Return main menu");
            System.out.println("------------------------------------");
            System.out.print("Your choose:  ");

            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("------------------------wrong format--------------------");
            }

            switch (choose) {
                case 1:
                    List<Employee> employeeList = iEmployeeRepository.display();
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    Employee addEmployee = employeeInfo();
                    iEmployeeRepository.add(addEmployee);
                    System.out.println("----------success----------");
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }

    public void searchEmployee() {
        System.out.print("Enter ID of people you want find: ");
        String id = scanner.nextLine();
        iEmployeeRepository.searchEmployee(id);
    }

    public void deleteEmployee() {
        System.out.print("enter ID of people you want delete: ");
        String id = scanner.nextLine();
        iEmployeeRepository.deleteEmployee(id);
    }


    private Employee employeeInfo() {
        Employee employee = new Employee();
        Boolean check = true;
        do {
            System.out.print("Code employee: ");
            String code = scanner.nextLine();
            check = CodeEmployeeException.checkCodeEmployee(code);
            employee.setCodeEmployee(code);
        } while (check == false);
        do {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            check = NameException.checkName(name);
            employee.setName(name);
        } while (check == false);
        System.out.print("Phone number: ");
        employee.setPhoneNumber(scanner.nextLine());
        System.out.print("Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.print("Gender: ");
        employee.setGender(scanner.nextLine());
        System.out.print("Date of birth: ");
        employee.setDateOfBirth(scanner.nextLine());
        do {
            System.out.print("ID employee:");
            String id =(scanner.nextLine());
            check = IDEmployeeException.checkID(id);
            employee.setID(id);
        }while (check == false);
        System.out.print("Standard: ");
        employee.setStandard(scanner.nextLine());
        double salary;
        do {
            System.out.print("Salary: ");
             salary = scanner.nextDouble();
            if (salary > 0) {
                employee.setSalary(Double.parseDouble(scanner.nextLine()));
            } else {
                System.out.println("salary > 0");
            }
        }while (salary < 0);
        System.out.print("Position: ");
        employee.setPosition(scanner.nextLine());

        return employee;
    }
}
