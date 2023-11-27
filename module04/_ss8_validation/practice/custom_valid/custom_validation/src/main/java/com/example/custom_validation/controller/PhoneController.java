package com.example.custom_validation.controller;

import com.example.custom_validation.bean.PhoneNumber;
import com.example.custom_validation.repository.PhoneRepository;
import com.example.custom_validation.validate.PhoneValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PhoneValidate phoneValidate;

    @GetMapping("/input_number")
    public String hone(Model model, @Validated @ModelAttribute("phone")PhoneNumber phone, BindingResult bindingResult) {
        phoneValidate.validate(phone,bindingResult);
        if (bindingResult.hasErrors()){
            return "/list";
        } else {
            return "/list";
        }
    }
}
