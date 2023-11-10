package org.example.repository;

import org.example.bean.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();
    void update(Email email);
    Email findById(int id);
}
