package com.example.case_study.repository;

import com.example.case_study.models.ServiceFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceFuramaRepository extends JpaRepository<ServiceFurama, Integer> {
    Page<ServiceFurama> findAllByStatusTrue(Pageable pageable);
}
