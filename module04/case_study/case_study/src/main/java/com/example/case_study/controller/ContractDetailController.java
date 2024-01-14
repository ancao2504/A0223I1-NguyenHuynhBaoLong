package com.example.case_study.controller;

import com.example.case_study.models.Contract;
import com.example.case_study.models.ContractDetail;
import com.example.case_study.service.attach_service.impl.AttachServiceImpl;
import com.example.case_study.service.contract.ContractService;
import com.example.case_study.service.contract_detail.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contractDetails")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceImpl attachService;
    @Autowired
    private ContractService contractService;

    @GetMapping("{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        List<ContractDetail> contractDetails = contractDetailService.findByContract_Id(id);
        model.addAttribute("contractDetails", contractDetails);
        model.addAttribute("id", id);
        return "contract_detail/list";
    }

    @GetMapping("/create/{id}")
    public String create(Model model, @PathVariable("id") int id) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachService", attachService.findAll());
        model.addAttribute("contract", contractService.findById(id));
        return "contract_detail/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("contractDetail") ContractDetail contractDetail, BindingResult bindingResult,
                       @RequestParam("idContract") int id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("attachService", attachService.findAll());
            model.addAttribute("contract", contractService.findById(id));
        } else {
            Contract contract = contractService.findById(id);
            contract.setTotal(contract.getTotal() + contractDetail.getAttachService().getCost() * contractDetail.getQuantity());
            contractDetail.setContract(contract);
            contractDetailService.save(contractDetail);
        }
        return "redirect:/contracts/list";
    }

}
