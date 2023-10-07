package com.example.casestudy.repository;

import com.example.casestudy.model.CustomerType;

import java.util.List;

public interface IRepositoryId<E> {
    List<E> findAll();

}
