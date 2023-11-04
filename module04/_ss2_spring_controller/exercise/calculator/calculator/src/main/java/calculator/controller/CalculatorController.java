package calculator.controller;

import calculator.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    ICalculator calculator;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public ModelAndView calculator(@RequestParam("number1") Double num1, @RequestParam("number2") Double num2, String val) {
        ModelAndView modelAndView = new ModelAndView("index");
        Double result = calculator.calculator(num1, num2, val);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
