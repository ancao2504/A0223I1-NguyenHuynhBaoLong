package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.CustomerType;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.CustomerTypeRepo;
import com.example.casestudy.service.ICustomerService;

import com.example.casestudy.service.impl.CustomerServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    private ICustomerService services = new CustomerServiceImpl();
    private IRepositoryId iFindRepo = new CustomerTypeRepo();

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
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
            default:
                listCustomer(request, response);
        }
    }


    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = services.findById(id);

        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<CustomerType> customerType = iFindRepo.findAll();
        Customer customer = services.findById(id);
        request.setAttribute("customer", customer);
        request.setAttribute("customerType", customerType);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypes = iFindRepo.findAll();
        request.setAttribute("customerTypes",customerTypes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = services.findAll();
        List<CustomerType> customerTypes = iFindRepo.findAll();
        request.setAttribute("customers", customers);
//        CustomerType customerTypes = iCustomerTypeService.findById(customers);
        request.setAttribute("customerTypes",customerTypes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/listCustomer.jsp");
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
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customer = services.findByName(name);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/find.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = services.findById(id);
        services.delete(customer);
        listCustomer(request, response);
//        System.out.println(id);
//        System.out.println("--------------delete--------" + customer);
//        services.delete(customer);
//        response.sendRedirect("/customer-servlet");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        //2023-05-11
        Date date = Date.valueOf(birthDay);
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        //int id, int idCustomerType, String name, Date birthDay, boolean gender, String idCard, String phone, String email, String address
        Customer customer = new Customer(id, idCustomerType, name, date, gender, idCard, phone, email, address);
        services.update(customer);

        listCustomer(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        //int idCustomerType, String name, Date birthDay, boolean gender, String idCard, String phone, String email, String address
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType"));
        System.out.println("------------id-----------"+idCustomerType);
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        //2023-05-11
        Date date = Date.valueOf(birthDay);
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(idCustomerType, name, date, gender, idCard, phone, email, address);
        request.setAttribute("customer", customer);
        services.save(customer);

        listCustomer(request, response);
    }
}
