package com.example.service.impl;

import com.example.models.CartItem;
import com.example.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public Double totalPrice(List<CartItem> cartItems) {
        Double total = 0.0;
        for (int i = 0; i < cartItems.size(); i++) {
            total += cartItems.get(i).getProduct().getPrice();
        }
        return total;
    }
}
