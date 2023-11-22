package org.example.controller;

import org.example.bean.Province;
import org.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;


    @GetMapping("/list")
    public String home (Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces",provinces);
        return "/province/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("province",new Province());
        return "/province/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("province") Province province){
        provinceService.save(province);
        return "redirect:/province/list";
    }
}
