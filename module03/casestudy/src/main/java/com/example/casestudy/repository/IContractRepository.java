package com.example.casestudy.repository;

import com.example.casestudy.model.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> findAll();
    void save (Contract contract);
    Contract FindById(int id);

    Boolean update(Contract contract);
    Boolean delete(Contract contract);
}
