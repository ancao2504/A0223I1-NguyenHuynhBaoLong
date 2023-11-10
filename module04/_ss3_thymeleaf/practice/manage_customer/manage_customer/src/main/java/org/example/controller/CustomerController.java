package org.example.controller;

import org.example.bean.Customer;
import org.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList =customerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";

    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random()*1000));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model) {
       model.addAttribute("customer",customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(),customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
        public String delete(@RequestParam("id") int id){
        customerService.delete(id);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
       Customer customer=customerService.findById(id);
        model.addAttribute("customers",customer);
        return "/view";
    }

}
