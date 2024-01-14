package com.example.case_study.controller;

import com.example.case_study.models.Customer;
import com.example.case_study.models.CustomerType;
import com.example.case_study.service.customer.CustomerService;
import com.example.case_study.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                       @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Customer> customers = customerService.findAllByStatusTrue(pageable);
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPage = customers.getTotalPages();
        for (int i = 1; i <= totalPage; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("pageSize", pageSize);
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypes);
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        } else {
            customer.setStatus(true);
            customerService.save(customer);
        }
        return "redirect:/customers/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDel") int id){
       Customer customer = customerService.findById(id);
       customer.setStatus(false);
       customerService.save(customer);
       return "redirect:/customers/list";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("name") String name,
                         @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Customer> customers = customerService.search(name,pageable );
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPage = customers.getTotalPages();
        for (int i = 1; i <= totalPage; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("pageSize", pageSize);
        return "customer/list";
    }


}
