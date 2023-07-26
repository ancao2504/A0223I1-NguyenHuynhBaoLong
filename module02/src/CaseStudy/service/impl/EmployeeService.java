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
    private  Scanner scanner = new Scanner(System.in);
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    public  void employeeMenu() {
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

            int choose =0;
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
                    if (iEmployeeRepository.add(addEmployee)) {
                        System.out.println("---------Success-------");
                    } else {
                        System.out.println("----------id already exists----------");
                    }
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 6:
                    check=false;
                    break;
            }
        }
    }

    private void deleteEmployee() {
        System.out.print("enter ID of people you want delete: ");
        String id = scanner.nextLine();
        Boolean employee = iEmployeeRepository.deleteEmployee(id);
        if (employee == true) {
            System.out.println("---------Delete success-----------");
        } else {
            System.out.println("-------Can't find id------");
        }
    }

    private  void editEmployee() {
        System.out.print("enter ID of people you want edit: ");
        String id = scanner.nextLine();
        Employee employee= (Employee) iEmployeeRepository.edit(id);
        if (employee != null) {
            System.out.println("---------------------------");
            System.out.println(employee);
            Boolean check =true;
            while (check) {
                System.out.println("1. name");
                System.out.println("2.code");
                System.out.println("3. gender");
                System.out.println("4.date of birth");
                System.out.println("5. phone number");
                System.out.println("6. email");
                System.out.println("7. ID");
                System.out.println("8. position");
                System.out.println("9. standard");
                System.out.println("10. exit");
                System.out.print("your choose: ");

                int choose =0;
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("------------------------wrong format--------------------");
                }

                switch (choose) {
                    case 1:
                        System.out.print("new name: ");
                        employee.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("new code: ");
                        employee.setCodeEmployee(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("new gender: ");
                        employee.setGender(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("new date of birth: ");
                        employee.setDateOfBirth(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("new Phone number: ");
                        employee.setPhoneNumber(Long.parseLong(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println("new email: ");
                        employee.setEmail(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("new ID: ");
                        employee.setID(scanner.nextLine());
                        break;
                    case 8:
                        System.out.println("position: ");
                        employee.setPosition(scanner.nextLine());
                        break;
                    case 9:
                        System.out.println("standard: ");
                        employee.setStandard(scanner.nextLine());
                        break;
                    case 10:
                        check = false;
                        break;
                    default:
                        System.out.println("Your choose is error!");
                        break;
                }

            }
        }
    }

    private  Employee employeeInfo() {
        Employee employee = new Employee();
        System.out.print("ID: ");
        employee.setID(scanner.nextLine());
        System.out.print("Name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Phone number: ");
        employee.setPhoneNumber(Long.parseLong(scanner.nextLine()));
        System.out.print("Email: ");
        employee.setEmail(scanner.nextLine());
        System.out.print("Gender: ");
        employee.setGender(scanner.nextLine());
        System.out.print("Date of birth: ");
        employee.setDateOfBirth(scanner.nextLine());
        System.out.print("Salary: ");
        employee.setSalary(Double.parseDouble(scanner.nextLine()));
        System.out.print("Code employee:");
        employee.setCodeEmployee(scanner.nextLine());
        System.out.print("Position: ");
        employee.setPosition(scanner.nextLine());
        System.out.print("Standard: ");
        employee.setStandard(scanner.nextLine());

        return employee;
    }
}
