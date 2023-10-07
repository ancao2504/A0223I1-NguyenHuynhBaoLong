package com.example.casestudy.service.impl;

import com.example.casestudy.model.Contract;
import com.example.casestudy.repository.IContractRepository;
import com.example.casestudy.repository.impl.ContractRepository;
import com.example.casestudy.service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository iContractRepository = new ContractRepository();
    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
    iContractRepository.save(contract);
    }
}
