package com.example.repository;

import com.example.bean.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluateRepository extends JpaRepository<Evaluate, Integer> {


}
