package com.example.casestudy.controller;

import com.example.casestudy.model.*;
import com.example.casestudy.service.IContractService;
import com.example.casestudy.service.IDetailContractService;
import com.example.casestudy.service.IService;
import com.example.casestudy.service.IServiceId;
import com.example.casestudy.service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailContractServlet", value = "/detailcontract-Servlet")
public class DetailContractServlet extends HttpServlet {
    private IDetailContractService detailContractService = new DetailContractService();
    private IServiceId<AttachService> attachService = new AttachServiceImpl();
    private IContractService iContractService = new ContractService();
    private IServiceId serviceType = new ServiceTypeImpl();
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
                listDetail(request, response);
                break;
        }

    }

    private void listDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetails = detailContractService.findAll();
        request.setAttribute("contractDetails", contractDetails);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detailContract/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        List<AttachService> attachServices = attachService.findAll();
        List<Contract> contracts = iContractService.findAll();
        request.setAttribute("attachServices", attachServices);
        request.setAttribute("contracts", contracts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detailContract/create.jsp");
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
//         int id, int idContract, int idAttachService, int quantity)
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        int idAttachService = Integer.parseInt(request.getParameter("idAttachService"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetai = new ContractDetail(idContract, idAttachService, quantity);
        detailContractService.save(contractDetai);
        listDetail(request, response);

    }
}
