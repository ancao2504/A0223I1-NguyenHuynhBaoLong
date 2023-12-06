package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class DetailBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5, max = 5)
    private String code;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public DetailBorrow() {
    }

    public DetailBorrow(Date borrowDate, Date dueDate) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public DetailBorrow(String code, Customer customer, Book book, Date borrowDate, Date dueDate) {
        this.code = code;
        this.customer = customer;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public DetailBorrow(String code) {
        this.code = code;
    }

    public DetailBorrow(Customer customer, Book book, Date borrowDate, Date dueDate) {
        this.customer = customer;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
