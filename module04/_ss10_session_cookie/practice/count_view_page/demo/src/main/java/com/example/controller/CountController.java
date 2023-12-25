package com.example.controller;

import com.example.model.Counter;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CountController {


    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        Counter counter = (Counter) session.getAttribute("counter");
        if (counter == null) {
            counter = new Counter();
            session.setAttribute("counter", counter);
        }
        counter.increment();
        model.addAttribute("counter",counter);
        return "/index";
    }
}
