package com.example.case_study.service.using_service.impl;


import com.example.case_study.models.Contract;
import com.example.case_study.service.using_service.UsingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UsingServiceImpl implements UsingService {

    @Override
    public List<Contract> findAllByEndDateAfter(Date nowDate) {
        return null;
    }
}
