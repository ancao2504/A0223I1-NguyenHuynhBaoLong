package org.example.controller;

import org.example.bean.Login;
import org.example.bean.User;
import org.example.repository.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerLogin {
    @Autowired
    RepositoryImpl repository;

    @GetMapping("/home")
    public String home(Model model) {
        Login login = new Login();
        model.addAttribute("login",login);
        return "/index";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = RepositoryImpl.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
