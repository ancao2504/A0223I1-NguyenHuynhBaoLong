package com.example.service;

import com.example.models.Book;
import org.springframework.data.jpa.repository.Query;

public interface IBookService extends IService<Book>{
    Book findAllByName(String name);
    void  updateQuantityBook(int quantity, String name);

    Boolean checkQuantity(int quantity);
}
