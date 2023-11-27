package com.example.validating.repository;

import com.example.validating.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface IUserRepository extends JpaRepository<User, Integer> {

}
