package CaseStudy.repository;

import CaseStudy.model.Employee;

import java.util.List;

public interface IRepositoryEmployee {
    void addEmployee(Employee employee);

    List<Employee> displayListEmployee();
}
