package CaseStudy.repository.impl;

import CaseStudy.model.Employee;
import CaseStudy.repository.IRepositoryEmployee;


import java.util.LinkedList;
import java.util.List;

public class RepositoryEmployee implements IRepositoryEmployee {
    private static final List<Employee> employees = new LinkedList<>();
    static {
        employees.add(new Employee("long","12/12/12222","NAM",12,1222,"asda@",1,"ád","ád "));
        employees.add(new Employee("long","12/12/12","nam",12,112,"asadda@",12,"á2d","ád"));
        employees.add(new Employee("long","12/12/12","nam",12,1,"asda@",123,"á23d","ád"));
    }
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> displayListEmployee() {
        return employees;
    }
}
