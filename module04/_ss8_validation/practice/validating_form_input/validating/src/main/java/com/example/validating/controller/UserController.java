package com.example.validating.controller;

import com.example.validating.bean.User;
import com.example.validating.service.IUserService;
import com.example.validating.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private UserValidate userValidate;

    @GetMapping("/list")
    public String home (@RequestParam(value = "page", defaultValue = "1",required = false) int pageNumber,
                        @RequestParam(value = "size", defaultValue = "5", required = false) int size, Model model){
        Pageable pageable = PageRequest.of(pageNumber -1 ,size, Sort.by(Sort.Direction.DESC,"date"));
        Page<User> users = userService.findAllAndPaging(pageable);
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPage = users.getTotalPages();
        for (int i = 1; i <= totalPage; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("users",users);
        model.addAttribute("pageNumbers",pageNumbers);
        model.addAttribute("size",size);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        userValidate.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        } else {
            userService.save(user);
            return "redirect:/users/list";
        }
    }
}
