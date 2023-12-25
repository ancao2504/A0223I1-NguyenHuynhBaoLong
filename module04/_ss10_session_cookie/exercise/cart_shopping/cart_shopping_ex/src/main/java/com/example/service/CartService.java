package com.example.service;

import com.example.models.CartItem;

import java.util.List;

public interface CartService {
    Double totalPrice(List<CartItem> cartItems);
}
