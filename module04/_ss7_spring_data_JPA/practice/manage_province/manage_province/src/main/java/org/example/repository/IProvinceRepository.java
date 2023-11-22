package org.example.repository;

import org.example.bean.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IProvinceRepository extends JpaRepository<Province, Integer> {
}
