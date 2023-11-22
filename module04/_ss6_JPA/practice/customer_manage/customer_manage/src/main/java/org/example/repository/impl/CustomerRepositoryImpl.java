package org.example.repository.impl;

import org.example.bean.Customer;
import org.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public void save(Customer customer) {
        if (entityManager.find(Customer.class,customer.getId()) != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Customer.class,id));
    }
}
