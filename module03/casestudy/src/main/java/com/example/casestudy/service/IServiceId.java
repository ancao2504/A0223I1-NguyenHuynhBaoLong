package com.example.casestudy.service;

import com.example.casestudy.model.CustomerType;

import java.util.List;

public interface IServiceId<E> {
    List<E> findAll();

}
