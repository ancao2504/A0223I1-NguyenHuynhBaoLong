package com.example.case_study.repository;

import com.example.case_study.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UsingService extends JpaRepository<Contract, Integer> {
    List<Contract> findAllByEndDateAfter(Date nowDate);
}
