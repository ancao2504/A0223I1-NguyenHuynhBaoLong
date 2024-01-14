package com.example.case_study.controller;

import com.example.case_study.models.Contract;
import com.example.case_study.service.attach_service.impl.AttachServiceImpl;
import com.example.case_study.service.contract.ContractService;
import com.example.case_study.service.customer.CustomerService;
import com.example.case_study.service.employee.EmployeeService;
import com.example.case_study.service.service.impl.ServiceFuramaImpl;
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
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private AttachServiceImpl attachService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceFuramaImpl serviceFurama;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(name = "page", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Contract> contracts = contractService.findAllAndPaging(pageable);
        int totalPage = contracts.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 1; i <= totalPage ; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("contracts", contracts);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumbers", pageNumbers);
        return "contract/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("attachService", attachService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("service", serviceFurama.findAll());
        return "contract/create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("customer", customerService.findAll());
            model.addAttribute("employee", employeeService.findAll());
            model.addAttribute("service", serviceFurama.findAll());
            return "contract/create";
        } else {
            Double totalMoney ;
            totalMoney = contract.getServiceFurama().getCost();
            contract.setTotal(totalMoney);
            contractService.save(contract);
        }
        return "redirect:/contracts/list";
    }
}
