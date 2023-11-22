package com.example.repository;

import com.example.bean.AppRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppRankRepository extends JpaRepository<AppRank,Integer> {

}
