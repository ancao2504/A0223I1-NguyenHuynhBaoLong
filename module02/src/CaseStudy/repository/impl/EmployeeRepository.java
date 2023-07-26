package CaseStudy.repository.impl;

import CaseStudy.model.Employee;
import CaseStudy.repository.IEmployeeRepository;

import java.util.*;

public class EmployeeRepository implements IEmployeeRepository<Employee> {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Map<String, Employee> map = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    static {
        employeeList.add(new Employee("long", 1223432, "acs", "b", "12/12/12",
                "1", "121", "ll", 123, "ádas"));
        employeeList.add(new Employee("b", 1223432, "acs", "b", "12/12/12",
                "2", "121", "ll", 123, "ádas"));
        employeeList.add(new Employee("a", 1223432, "acs", "b", "12/12/12",
                "3", "121", "ll", 123, "ádas"));

        for (Employee employee : employeeList) {
            map.put(employee.getID(), employee);
        }
    }

    @Override
    public List display() {
        return employeeList;
    }

    @Override
    public Boolean add(Employee employee) {
        if (!map.containsKey(employee.getID())) {
            employeeList.add(employee);
            map.put(employee.getID(), employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee edit(String id) {
        if (!map.containsKey(id)) {
            return null;
        } else {
            return map.get(id);
        }
    }

    @Override
    public Boolean deleteEmployee(String id) {
        if (!map.containsKey(id)) {
            return false;
        } else {
            employeeList.remove(map.get(id));
            return true;
        }
    }
}
