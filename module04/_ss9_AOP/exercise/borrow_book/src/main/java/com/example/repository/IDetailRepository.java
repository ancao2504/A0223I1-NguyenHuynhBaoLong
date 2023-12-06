package com.example.repository;

import com.example.models.DetailBorrow;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDetailRepository extends JpaRepository<DetailBorrow, Integer> {

    DetailBorrow findByCode(String code);
    @Modifying
    @Transactional
    @Query("DELETE FROM DetailBorrow d where d.code= :code")
    void dueBorrow(String code);

}
