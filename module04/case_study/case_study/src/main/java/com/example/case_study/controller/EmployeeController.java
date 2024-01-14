package com.example.case_study.controller;

import com.example.case_study.models.Employee;
import com.example.case_study.service.division.DivisionService;
import com.example.case_study.service.education_degree.EducationDegreeService;
import com.example.case_study.service.employee.EmployeeService;
import com.example.case_study.service.position.PositionService;
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
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                       @RequestParam(name = "pageSize", defaultValue = "5", required = false) int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Employee> employees = employeeService.findAllByStatusTrueAndPaging(pageable);
        int totalPage = employees.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 1; i <= totalPage; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("employees", employees);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumbers", pageNumbers);
        return "employee/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisions", divisionService.findAll());
            model.addAttribute("positions", positionService.findAll());
            model.addAttribute("educationDegrees", educationDegreeService.findAll());
            return "employee/create";
        } else {
            employee.setStatus(true);
            employeeService.save(employee);
        }
        return "redirect:/employees/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        return "employee/create";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDel") int id) {
        Employee employee = employeeService.findById(id);
        employee.setStatus(false);
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("name") String name,
                         @RequestParam(name = "page", required = false, defaultValue = "1") int pageNumber,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Employee> employees = employeeService.search(name,pageable);
        int totalPage = employees.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 1; i <= totalPage; i++) {
            pageNumbers.add(i);
        }
        model.addAttribute("employees", employees);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumbers", pageNumbers);
        return "employee/list";
    }

}
