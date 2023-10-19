package com.example.casestudy.controller;

import com.example.casestudy.model.Contract;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Employee;
import com.example.casestudy.model.Service;
import com.example.casestudy.service.IContractService;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.IEmployeeService;
import com.example.casestudy.service.IService;
import com.example.casestudy.service.impl.ContractService;
import com.example.casestudy.service.impl.CustomerServiceImpl;
import com.example.casestudy.service.impl.EmployeeServiceImpl;
import com.example.casestudy.service.impl.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contract-servlet")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractService();
    private ICustomerService customerService = new CustomerServiceImpl();
    private IEmployeeService employeeService =  new EmployeeServiceImpl();
    private IService service = new ServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            default:
                listContract(request, response);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Service>  services = service.findAll();
        request.setAttribute("employees",employees);
        request.setAttribute("customers",customers);
        request.setAttribute("services",services);
    RequestDispatcher requestDispatcher =request.getRequestDispatcher("contract/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contracts = contractService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Employee> employees = employeeService.findAll();
        List<Service> services = service.findAll();
        request.setAttribute("contracts",contracts);
        request.setAttribute("customers",customers);
        request.setAttribute("employees",employees);
        request.setAttribute("services",services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        //int id, Date startContract, Date endContract, double depositContract, double totalMoney,
        //                    int idEmployee, int idCustomer, int idService
        //(Date startContract, Date endContract, double depositContract, double totalMoney, int idEmployee, int idCustomer, int idService) {
        String start= request.getParameter("startContract");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
        try {
            date=simpleDateFormat.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String end= request.getParameter("endContract");
        Date endDate = new Date();
        try {
            endDate=simpleDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double deposit = Double.parseDouble(request.getParameter("depositContract"));
        double total = Double.parseDouble(request.getParameter("totalMoney"));
        int idEmployee= Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer= Integer.parseInt(request.getParameter("idCustomer"));
        int idService= Integer.parseInt(request.getParameter("idService"));
        Contract contract = new Contract(date, endDate, deposit, total, idEmployee, idCustomer, idService);
        contractService.save(contract);
        request.setAttribute("mess", "Create Success");
       listContract(request,response);
    }
}
