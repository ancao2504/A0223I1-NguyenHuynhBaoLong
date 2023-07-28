package CaseStudy.repository;

import CaseStudy.model.Employee;

import java.util.List;

public interface IEmployeeRepository<E> {
    List<E> display();

    void add(E e);


    //E edit(String id);

    void deleteEmployee(String id);

    void searchEmployee(String id);
}
