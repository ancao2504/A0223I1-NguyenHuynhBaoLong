package CaseStudy.repository;

import CaseStudy.model.Employee;

import java.util.List;

public interface IEmployeeRepository<E> {
    List<E> display();

    Boolean add(E e);


    E edit(String id);

    Boolean deleteEmployee(String id);
}
