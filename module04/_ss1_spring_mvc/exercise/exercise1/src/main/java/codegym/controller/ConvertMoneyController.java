package codegym.controller;

import codegym.service.IConvertMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {
    @Autowired
    IConvertMoney convertMoney;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam String usd, Model model) {
        model.addAttribute("result",convertMoney.convert(Double.valueOf(usd)));
        return "home";
    }
}
