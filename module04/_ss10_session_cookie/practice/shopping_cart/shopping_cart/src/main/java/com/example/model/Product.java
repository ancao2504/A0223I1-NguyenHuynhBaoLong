package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    private int quantity;

    private String description;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public Product() {
    }

    public Product(String name, Double price, int quantity, String description, Cart cart) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.cart = cart;
    }

    public Product(String name, Double price, String description, Cart cart) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
