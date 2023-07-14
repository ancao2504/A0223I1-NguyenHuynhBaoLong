package CaseStudy.repository;

import CaseStudy.model.Employee;

import java.util.List;

public interface IRepository<E> {
    void add(E e);

    List<E> display();



    void edit(String inputNameCheck);
}
