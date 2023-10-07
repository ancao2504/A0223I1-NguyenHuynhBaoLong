package com.example.casestudy.controller;

import com.example.casestudy.model.Contract;
import com.example.casestudy.service.IContractService;
import com.example.casestudy.service.impl.ContractService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contract-servlet")
public class ContractServlet extends HttpServlet {
    private IContractService services = new ContractService();
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
        List<Contract> contracts = services.findAll();
        request.setAttribute("contracts",contracts);
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
        Date startDate =Date.valueOf(start);
        String end= request.getParameter("endContract");
        Date endDate =Date.valueOf(end);
        double deposit = Double.parseDouble(request.getParameter("depositContract"));
        double total = Double.parseDouble(request.getParameter("totalMoney"));
        int idEmployee= Integer.parseInt(request.getParameter("idEmployee"));
        int idCustomer= Integer.parseInt(request.getParameter("idCustomer"));
        int idService= Integer.parseInt(request.getParameter("idService"));
        Contract contract = new Contract(startDate, endDate, deposit, total, idEmployee, idCustomer, idService);
        services.save(contract);
        request.setAttribute("mess", "Create Success");
       listContract(request,response);
    }
}
