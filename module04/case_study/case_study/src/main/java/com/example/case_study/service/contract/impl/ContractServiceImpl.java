package com.example.case_study.service.contract.impl;

import com.example.case_study.models.Contract;
import com.example.case_study.repository.ContractRepository;
import com.example.case_study.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
       contract.setCode(createCode());
        contractRepository.save(contract);
    }

    @Override
    public void delete(int id) {
        contractRepository.delete(contractRepository.findById(id).orElse(null));
    }

    @Override
    public Page<Contract> findAllAndPaging(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public String createCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            int random =(int) (Math.random() * 10);
            stringBuilder.append(random);
        }
        return String.valueOf(stringBuilder);
    }
}
