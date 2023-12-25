package com.example.controller;

import com.example.models.CartItem;
import com.example.models.Product;
import com.example.service.CartService;
import com.example.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public String list(HttpSession session,Model model ) {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        model.addAttribute("cartItems",cartItems);
        Double total =cartService.totalPrice(cartItems);
        model.addAttribute("total",total);
        return "cart/list";
    }

    @GetMapping("updateQuantity")
        public void updateQuantity(@RequestParam("newQuantity") int quantity, @RequestParam("nameProduct") String nameProduct,HttpSession session){
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        for (CartItem item : cartItems) {
            if (item.getProduct().getName().equals(nameProduct)) {
                item.setQuantity(quantity);
                break;
            }
        }
        System.out.println("--------------quantity DB-------------"+quantity);
        System.out.println("--------------nameProduct DB-------------"+nameProduct);
    }

    @GetMapping("/add")
    public String addCart( HttpSession session, @RequestParam("id") Long id,
                       RedirectAttributes redirectAttributes) {
        Product product = productService.findByID(id);
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        Boolean productExist = false;
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItems.add(cartItem);
            session.setAttribute("cartItems", cartItems);
        } else {
            for (CartItem item : cartItems) {
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() + 1);
                    productExist = true;
                    break;
                }
            }
            if (!productExist) {
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                cartItems.add(cartItem);
                session.setAttribute("cartItems", cartItems);
            }
        }
       redirectAttributes.addFlashAttribute("cartItems",cartItems);

        return "redirect:/carts/list";
    }
}
