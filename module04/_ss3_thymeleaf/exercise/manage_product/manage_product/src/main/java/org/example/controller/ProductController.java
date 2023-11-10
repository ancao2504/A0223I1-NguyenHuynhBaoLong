package org.example.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.example.bean.Product;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String listProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/create")
    public String createForm(Product product, Model model) {
        model.addAttribute("product", product);
        model.addAttribute("action", "create");
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, @RequestParam("action") String action) {
        System.out.println(action);
        System.out.println(product.getId());
        if ("create".equals(action)) {
            productService.save(product);
        } else {
            productService.update(product.getId(), product);
        }
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("action", "update");
        return "/create";
    }

    @GetMapping("/{id}/delete")
    public String deleteForm(Model model, @PathVariable int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product) {
        System.out.println("delete"+product.getId());
        productService.delete(product.getId());
        return "redirect:/product";
    }

}
