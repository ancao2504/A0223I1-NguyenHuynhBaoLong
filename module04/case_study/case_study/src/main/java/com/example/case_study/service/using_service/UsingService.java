package com.example.case_study.service.using_service;

import com.example.case_study.models.Contract;

import java.util.Date;
import java.util.List;

public interface UsingService {
    List<Contract> findAllByEndDateAfter(Date nowDate);
}
