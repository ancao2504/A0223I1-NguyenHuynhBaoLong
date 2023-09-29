package com.example.product_management.model;

import java.util.Date;

public class Product {
    private String name;
    private int id;
    private String dateManufacture;
    private String dateExpiry;

    public Product() {
    }

    public Product(String name, int id, String dateManufacture, String dateExpiry) {
        this.name = name;
        this.id = id;
        this.dateManufacture = dateManufacture;
        this.dateExpiry = dateExpiry;
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

    public String getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(String dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
}
