package org.example.controller;

import org.example.bean.AppRank;
import org.example.bean.Evaluate;
import org.example.repository.IAppRankRepository;
import org.example.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EvaluateController {
    @Autowired
    private IEvaluateService evaluateService;

    @Autowired
    private IAppRankRepository iAppRankRepository;


    @GetMapping("/list")
    public String home(Model model) {
        List<Evaluate> evaluates = evaluateService.findAll();
        model.addAttribute("evaluates",evaluates);
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
        evaluateService.create(evaluate);
        return "redirect:/list";
    }

    @GetMapping("/countLike/{id}")
    public String count(Model model, @PathVariable("id") int id) {
        Evaluate evaluate =evaluateService.findById(id);
        evaluate.setCountLike( evaluate.getCountLike()+1);
        evaluateService.updateLike(evaluate);
        return "redirect:/list";
    }
}
