package com.example.controller;

import com.example.models.Book;
import com.example.models.Customer;
import com.example.models.DetailBorrow;
import com.example.service.IBookService;
import com.example.service.ICustomerService;
import com.example.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IDetailService detailService;

    @GetMapping("/list")
    public String home(Model model) {
        List<Customer> customers = customerService.findAll();
        List<DetailBorrow> detailBorrows = detailService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("detailBorrows", detailBorrows);
        model.addAttribute("detailBorrow", new DetailBorrow());
        return "customer/list";
    }

    @GetMapping("/borrow/{ids}")
    public String create(@PathVariable("ids") String ids, Model model,RedirectAttributes redirectAttributes) {
        String[] selected = ids.split(",");
        List<String> bookSelected = new ArrayList<>();
        List<Book> books = bookService.findAll();
        Boolean quantity;
        for (int i = 0; i < selected.length; i++) {
            bookSelected.add(bookService.findById(Integer.parseInt(selected[i])).getName());
           quantity= bookService.checkQuantity( bookService.findById(Integer.parseInt(selected[i])).getQuantity());
           if (quantity == true) {
               continue;
           }else {
               redirectAttributes.addFlashAttribute("msg","het sach");
               return "redirect:/books/list";
           }
        }
        model.addAttribute("customer", new Customer());
        model.addAttribute("books", books);
        model.addAttribute("bookSelected", bookSelected);
        model.addAttribute("detailBorrow", new DetailBorrow());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                       @RequestParam("book-selected") String[] bookSelected,
                       @ModelAttribute("detailBorrow") DetailBorrow detailBorrow, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookSelected", bookSelected);
            return "/customer/create";
        } else {
            customerService.save(customer);
            Date borrowDate = detailBorrow.getBorrowDate();
            Date dueDate = detailBorrow.getDueDate();
            int quantity = 0;
            for (int i = 0; i < bookSelected.length; i++) {
                quantity = bookService.findAllByName(bookSelected[i]).getQuantity();
                quantity--;
                bookService.updateQuantityBook(quantity, bookSelected[i]);
                DetailBorrow detail = new DetailBorrow(borrowDate, dueDate);
                detail.setBook(bookService.findAllByName(bookSelected[i]));
                detail.setCustomer(customer);
                detailService.save(detail);
            }
            return "redirect:/customers/list";
        }
    }

    @GetMapping("/due")
    public String dueBorrow(@ModelAttribute("detailBorrow") DetailBorrow detailBorrow, @RequestParam("code") String code,
                            RedirectAttributes redirectAttributes) {
        detailBorrow = detailService.findByCode(code);
        if (detailBorrow == null) {
            redirectAttributes.addFlashAttribute("msg", "invalid code");
            return "redirect:/customers/list";
        } else {
            int quantity = detailBorrow.getBook().getQuantity();
            quantity++;
            String nameBook = detailBorrow.getBook().getName();
            bookService.updateQuantityBook(quantity, nameBook);
            int idCustomer = detailBorrow.getCustomer().getId();
            detailService.dueBorrow(code);
            customerService.delete(idCustomer);
            return "redirect:/customers/list";
        }
    }
}
