package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Employee;
import CaseStudy.repository.IEmployeeRepository;

import java.util.*;

public class EmployeeRepository implements IEmployeeRepository<Employee> {
    public static final String SRC_EMPLOYEE = "src/CaseStudy/data/Employee.csv";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public List<Employee> display() {
        List<Employee> employees = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFile(SRC_EMPLOYEE);
        String[] temp = new String[0];
        for (String string : stringList) {
            temp = string.split(",");
            if (temp.length == 10) {
                employees.add(new Employee(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], Double.parseDouble(temp[8]), temp[9]));
            }
        }
        return employees;
    }
// String name, String phoneNumber, String email, String gender, String dateOfBirth, String iD, String codeEmployee, String standard, double salary, String position

    @Override
    public void add(Employee employee) {
        ReadAndWriteFile.writeFile(SRC_EMPLOYEE, convertToString(employee), true);
    }

    @Override
    public void deleteEmployee(String id) {
        List<String> lines = ReadAndWriteFile.readFile(SRC_EMPLOYEE);
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            String[] temp = line.split(",");
            if (temp[5].equals(id)) {
                if (temp[6].startsWith("N")) { // Employee
                    System.out.println("Are you sure you want to delete this employee with ID: " + id);
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        // Skip adding this line to the newLines list
                        System.out.println("xóa thành công");
                    } else {
                        newLines.add(line);
                    }
                } else {
                    newLines.add(line);
                }
            } else {
                newLines.add(line);
            }
        }
        ReadAndWriteFile.writeFile(SRC_EMPLOYEE, String.join("\n", newLines), false);

    }
//    public void deleteEmployee(String id) {
//        List<Employee> list = display();
//        for (Employee employee : list) {
//            if (employee.getID().equals(id) ) {
//                if ()
//                System.out.println("You sure to delete this employee get id: " + id);
//                System.out.println("1. Yes");
//                System.out.println("2.No");
//                int choice = Integer.parseInt(new Scanner(System.in).nextLine());
//                if (choice == 1) {
//                    list.remove(employee);
//                    String line = "";
//                    for (Employee newEmployee : list) {
//                        line += convertToString(newEmployee) + "\n";
//                    }
//                    line = line.substring(0, line.length() - 1);
//                    ReadAndWriteFile.writeFile(SRC_EMPLOYEE, line, false);
//                    System.out.println("xóa thành công");
//                }
//                break;
//            }
//        }
//    }

    @Override
    public void searchEmployee(String id) {
        List<Employee> list = display();
        for (Employee employee : list) {
            if (employee.getID().equals(id)) {
                System.out.println(employee.toString());
                break;
            }
        }
    }

    @Override
    public boolean edit(String id) {
        List<Employee> list = display();
        for (Employee employee : list) {
            if (employee.getID().equals(id)) {
                System.out.println(employee.toString());
                list.remove(employee);
                String line = "";
                for (Employee newEmployee : list) {
                    line += convertToString(newEmployee) + "\n";
                }
                line = line.substring(0, line.length() - 1);
                ReadAndWriteFile.writeFile(SRC_EMPLOYEE, line, false);
                return true;
            }
        }
        return false;
    }

    private String convertToString(Employee employee) {
        return employee.getName() + "," + employee.getPhoneNumber() + "," + employee.getEmail() + "," + employee.getGender() + "," + employee.getDateOfBirth() +
                "," + employee.getID() + "," + employee.getCodeEmployee() + "," + employee.getStandard() + "," + employee.getSalary() + "," + employee.getPosition();
    }
}

