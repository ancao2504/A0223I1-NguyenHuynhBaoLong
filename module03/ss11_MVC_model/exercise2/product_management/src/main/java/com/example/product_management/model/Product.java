package com.example.product_management.model;

import java.util.Date;

public class Product {
    private String name;
    private int id;
    private double price;
    private String detail;

    public Product() {
    }

    public Product(String name, int id, double price, String detail) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
