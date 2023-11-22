package com.example.controller;

import com.example.repository.IAppRankRepository;
import com.example.bean.Evaluate;
import com.example.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EvaluateController {
    @Autowired
    private IEvaluateService evaluateService;

    @Autowired
    private IAppRankRepository iAppRankRepository;


    @GetMapping("/list")
    public String home(Model model, @RequestParam(name = "page",defaultValue = "1", required = false) int pageNumber,
                       @RequestParam(name = "size", required = false,defaultValue = "3") int size){
        Pageable pageable = PageRequest.of(pageNumber-1,size, Sort.by(Sort.Direction.ASC,"countLike"));
        Page<Evaluate> evaluates =evaluateService.findAllAndPaging(pageable);
        int totalPage = evaluates.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            pageNumbers.add(i + 1);
        }
        model.addAttribute("evaluates",evaluates);
        model.addAttribute("size",size);
        model.addAttribute("pageNumbers",pageNumbers);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("evaluate",new Evaluate());
        model.addAttribute("rank",iAppRankRepository.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Evaluate evaluate) {
        evaluateService.save(evaluate);
        return "redirect:/list";
    }

    @GetMapping("/countLike/{id}")
    public String count(Model model, @PathVariable("id") int id) {
        Evaluate evaluate =evaluateService.findById(id);
        evaluate.setCountLike( evaluate.getCountLike()+1);
        evaluateService.save(evaluate);
        return "redirect:/list";
    }
}
