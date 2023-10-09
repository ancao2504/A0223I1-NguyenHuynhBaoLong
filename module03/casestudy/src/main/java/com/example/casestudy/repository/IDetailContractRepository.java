package com.example.casestudy.repository;

import com.example.casestudy.model.ContractDetail;

import java.util.List;

public interface IDetailContractRepository {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
