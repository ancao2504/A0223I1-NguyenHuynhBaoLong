package com.example.service.impl;

import com.example.models.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(bookRepository.findById(id).orElse(null));
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findAllByName(String name) {
       return bookRepository.findAllByName(name);
    }

    @Override
    public void updateQuantityBook(int quantity, String name) {
        bookRepository.updateQuantityBook(quantity,name);
    }

    @Override
    public Boolean checkQuantity(int quantity) {
        if (quantity == 0) {
            return false;
        }
        return true;
    }
}
