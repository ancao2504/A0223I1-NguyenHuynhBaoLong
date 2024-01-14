package com.example.case_study.controller;

import com.example.case_study.models.ServiceFurama;
import com.example.case_study.service.rent_type.RentTypeService;
import com.example.case_study.service.service.impl.ServiceFuramaImpl;
import com.example.case_study.service.service_type.impl.ServiceTypeImpl;
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
@RequestMapping("/services")
public class ServiceFuramaController {
    @Autowired
    private ServiceFuramaImpl serviceFuramaImpl;
    @Autowired
    private ServiceTypeImpl serviceType;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(name = "page" , defaultValue = "1", required = false) int pageNumber,
                       @RequestParam(name = "pageSize", defaultValue = "5", required = false) int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber -1,pageSize);
        Page<ServiceFurama> services = serviceFuramaImpl.findAllByStatusTrueAndPaging(pageable);
        int totalPage= services.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 1; i <= totalPage ; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("services", services);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("pageSize", pageSize);
        return "service/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("service", new ServiceFurama());
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("serviceType", serviceType.findAll());
        return "service/create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("service")ServiceFurama serviceFurama, BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("rentType", rentTypeService.findAll());
            model.addAttribute("serviceType", serviceType.findAll());
            return "service/create";
        } else {
            serviceFurama.setStatus(true);
            serviceFuramaImpl.save(serviceFurama);
        }
        return "redirect:/services/list";
    }

}
