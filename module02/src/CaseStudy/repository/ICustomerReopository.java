package CaseStudy.repository;

import CaseStudy.model.Customer;
import CaseStudy.model.Employee;

import java.util.List;

public interface ICustomerReopository <E> {
    void add(E customer);

    List<E> display();

    void search(String name);

    void delete(String id);
}
