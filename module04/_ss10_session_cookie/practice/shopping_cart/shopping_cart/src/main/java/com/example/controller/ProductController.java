package com.example.controller;

import com.example.model.CartItem;
import com.example.model.Product;
import com.example.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public String home(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/add/{id}")
    public String addCart(Model model, @PathVariable("id") int id,HttpSession session) {
        Product product = productService.findByID(id);
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        Boolean productExist=false;
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItems.add(cartItem);
            session.setAttribute("cartItems",cartItems);
        } else  {
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == product.getId()) {
                    cartItem.setQuantity(cartItem.getQuantity()+1);
                    productExist=true;
                    break;
                }
            }
            if (!productExist) {
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                cartItems.add(cartItem);
            }
        }
        model.addAttribute("cartItems", cartItems);
        return "cart/list";
    }
}
