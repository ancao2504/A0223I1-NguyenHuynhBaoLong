package com.example.case_study.repository;

import com.example.case_study.models.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDetailRepository  extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findByContract_Id(int idContract);
}
