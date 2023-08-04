package CaseStudy.repository.impl;

import CaseStudy.common.ReadAndWriteFile;
import CaseStudy.model.Employee;
import CaseStudy.repository.IEmployeeRepository;
import ss16.mvc.common.ReadWriteFile;
import ss16.mvc.model.Student;

import java.util.*;

public class EmployeeRepository implements IEmployeeRepository<Employee> {
    public static final String SRC_EMPLOYEE = "src/CaseStudy/data/Employee.csv";
    private Scanner scanner = new Scanner(System.in);



    @Override
    public List<Employee> display() {
        List<Employee> employees = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFile(SRC_EMPLOYEE);
        String[] temp;
        for (String string : stringList) {
            temp = string.split(",");

            employees.add(new Employee(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], Double.parseDouble(temp[8]), temp[9]));
        }
        return employees;
    }


    @Override
    public void add(Employee employee) {
        ReadAndWriteFile.writeFile(SRC_EMPLOYEE, convertToString(employee), true);
    }

    @Override
    public void deleteEmployee(String id) {
      List<Employee> list = display();
        for(Employee employee : list){
            if (employee.getID().equals(id)) {
                System.out.println("You sure to delete this employee get id: "+id);
                System.out.println("1. Yes");
                System.out.println("2.No");
                int choice = Integer.parseInt(new Scanner(System.in).nextLine());
                if (choice==1) {
                    list.remove(employee);
                    String line ="";
                    for (Employee newEmployee : list) {
                        line+=convertToString(newEmployee)+"\n";
                    }
                    line = line.substring(0, line.length()-1);
                    ReadAndWriteFile.writeFile(SRC_EMPLOYEE,line,false);
                    System.out.println("xóa thành công");
                }
                break;
            }
        }
    }

    @Override
    public void searchEmployee(String id) {
        List<Employee> list = display();
        for (Employee employee :list) {
            if (employee.getID().equals(id)) {
                System.out.println(employee.toString());
                break;
            }
        }

    }

    @Override
    public boolean edit(String id) {
        List<Employee> list = display();
        for(Employee employee : list){
            if (employee.getID().equals(id)) {
                System.out.println(employee.toString());
                    list.remove(employee);
                    String line ="";
                    for (Employee newEmployee : list) {
                        line+=convertToString(newEmployee)+"\n";
                    }
                    line = line.substring(0, line.length()-1);
                    ReadAndWriteFile.writeFile(SRC_EMPLOYEE,line,false);
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

