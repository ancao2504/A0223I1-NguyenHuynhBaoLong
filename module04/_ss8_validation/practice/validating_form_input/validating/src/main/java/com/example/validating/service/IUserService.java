package com.example.validating.service;

import com.example.validating.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAllAndPaging(Pageable pageable);
    void save(User user);
    User findById(int id);
}
