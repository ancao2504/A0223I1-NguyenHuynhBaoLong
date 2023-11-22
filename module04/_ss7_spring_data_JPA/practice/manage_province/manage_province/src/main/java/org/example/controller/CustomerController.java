package org.example.controller;

import org.example.bean.Customer;
import org.example.bean.Province;
import org.example.service.ICustomerService;
import org.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/list")
    public String home(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinces", provinces);
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("customer",customer);
        model.addAttribute("action","edit");
        model.addAttribute("provinces", provinces);

        return "/customer/create";
    }
}
