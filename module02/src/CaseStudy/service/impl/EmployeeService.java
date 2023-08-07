package CaseStudy.service.impl;

import CaseStudy.Exception.*;
import CaseStudy.common.EmployeeComparator;
import CaseStudy.model.Employee;
import CaseStudy.repository.IEmployeeRepository;
import CaseStudy.repository.impl.EmployeeRepository;
import CaseStudy.service.IEmployeeService;

import java.util.*;

public class EmployeeService implements IEmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    private List<Employee> list = new ArrayList<>();

    public void employeeMenu() {
        Boolean check = true;
        while (check) {
            System.out.println("------------Employee Menu-----------");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
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
                    display();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    editEmployee();
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

    public void addEmployee() {
        Employee addEmployee = employeeInfo();
        iEmployeeRepository.add(addEmployee);
    }

    public void display() {
        List<Employee> employeeList = iEmployeeRepository.display();
        Comparator<Employee> comparator = new EmployeeComparator();
        Collections.sort(employeeList,comparator);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void editEmployee() {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        if (iEmployeeRepository.edit(id) == true) {
            Employee addEmployee = employeeInfo();
            iEmployeeRepository.add(addEmployee);
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
        do {
            System.out.print("Email: ");
            String email = (scanner.nextLine());
            check = EmailException.checkEmail(email);
            employee.setEmail(email);
        } while (check == false);
        do {
            System.out.print("Gender: ");
            String gender = (scanner.nextLine());
            check = GenderException.checkGender(gender);
            employee.setGender(gender);
        } while (check == false);
        do {
            System.out.print("Date of birth: ");
            String dateOfBirth = (scanner.nextLine());
            check = DateOfBirthException.checkDateOfBirth(dateOfBirth);
            employee.setDateOfBirth(dateOfBirth);
        } while (check == false);
        do {
            System.out.print("ID employee:");
            String id = (scanner.nextLine());
            check = IDEmployeeException.checkID(id);
            employee.setID(id);
        } while (check == false);
        do {
            System.out.print("Standard: ");
            String standard = scanner.nextLine();
            check = StandardException.checkStandard(standard);
            employee.setStandard(standard);
        }while (check == false);
        System.out.print("salary: ");
        employee.setSalary(Double.parseDouble(scanner.nextLine()));
        System.out.print("Position: ");
        employee.setPosition(scanner.nextLine());


        return employee;
    }
}
