package org.example.controller;

import org.example.bean.Email;
import org.example.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailRepository emailRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Email> email= emailRepository.findAll();
        model.addAttribute("email",email);
        return "/index";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id,Model model) {
        Email email = emailRepository.findById(id);
        model.addAttribute("email",email);
        model.addAttribute("languages",getLanguage());
        model.addAttribute("size",getSizePage());
        return "/edit";
    }

    @PostMapping("/update")
    public String update( Email email){
        emailRepository.update(email);
        return "redirect:/home";
    }

    private List<String> getSizePage() {
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("10");
        list.add("15");
        list.add("20");
        return list;
    }

    private List<String> getLanguage() {
        List<String> list = new ArrayList<>();
        list.add("english");
        list.add("vietnamese");
        list.add("japanese");
        list.add("Chinese");
        return list;
    }


}
