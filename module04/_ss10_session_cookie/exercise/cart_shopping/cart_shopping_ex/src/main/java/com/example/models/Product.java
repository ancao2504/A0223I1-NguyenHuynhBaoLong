package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    @Min(0)
    private int quantity;

    @Pattern(regexp="([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(double price, int quantity, String name, Cart cart) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
