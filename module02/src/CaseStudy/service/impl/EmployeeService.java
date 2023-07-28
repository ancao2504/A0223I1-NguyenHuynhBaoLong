package CaseStudy.service.impl;

import CaseStudy.Exception.NameException;
import CaseStudy.model.Employee;
import CaseStudy.repository.IEmployeeRepository;
import CaseStudy.repository.impl.EmployeeRepository;
import CaseStudy.service.IEmployeeService;
import org.omg.CORBA.UserException;

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
        List<Employee> employeeList = iEmployeeRepository.display();
        if (employeeList.isEmpty()) {
            employee.setCodeEmployee("NV-00");
        } else {
            employee.setCodeEmployee(employeeList.get(employeeList.size() - 1).getCodeEmployee() + 1);
        }
        System.out.print("Name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Phone number: ");
        employee.setPhoneNumber(scanner.nextLine());
        System.out.print("Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.print("Gender: ");
        employee.setGender(scanner.nextLine());
        System.out.print("Date of birth: ");
        employee.setDateOfBirth(scanner.nextLine());
        System.out.print("ID employee:");
        employee.setID(scanner.nextLine());
        System.out.print("Standard: ");
        employee.setStandard(scanner.nextLine());
        System.out.print("Salary: ");
        employee.setSalary(Double.parseDouble(scanner.nextLine()));
        System.out.print("Position: ");
        employee.setPosition(scanner.nextLine());

        return employee;
    }
}
