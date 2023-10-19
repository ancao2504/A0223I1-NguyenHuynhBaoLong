package com.example.casestudy.controller;

import com.example.casestudy.common.Validate;
import com.example.casestudy.model.*;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.CustomerTypeRepo;
import com.example.casestudy.service.*;

import com.example.casestudy.service.impl.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;


@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    private ICustomerService services = new CustomerServiceImpl();
    private IRepositoryId iFindRepo = new CustomerTypeRepo();
    private IDetailCustomerService detailCustomerService = new DetailCustomerServiceImpl();
    private IServiceId<AttachService> attachService = new AttachServiceImpl();

    private IServiceId<ServiceType> serviceType = new ServiceTypeImpl();
    private IService service = new ServiceImpl();
    private IServiceId<CustomerType> customerType = new CusomerTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
            case "customerAreUsing":
                listCustomerUsing(request,response);
                break;
            default:
                listCustomer(request, response);
        }
    }

    private void listCustomerUsing(HttpServletRequest request, HttpServletResponse response) {
    List<DetailCustomer> detailCustomers = detailCustomerService.list();
        List<AttachService> attachServices = attachService.findAll();
        List<ServiceType> ServiceType = serviceType.findAll();
        List<Service> services = service.findAll();
        List<CustomerType> customerTypes = customerType.findAll();
        request.setAttribute("attachServices", attachServices);
        request.setAttribute("ServiceType", ServiceType);
        request.setAttribute("services", services);
    request.setAttribute("detailCustomers",detailCustomers);
    request.setAttribute("customerTypes",customerTypes);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/detail.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        request.setCharacterEncoding("UTF-8");
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        //int id, int idCustomerType, String name, Date birthDay, boolean gender, String idCard, String phone, String email, String address
        boolean flag =true;
        String errorCode=null;
        String errorEmail =null;
        String errorPhone =null;

        if (!Validate.checkIdCardCustomer(idCard)) {
            errorCode="9 số hoặc 12 số";
            flag=false;
        }
        if (!Validate.checkEmail(email)) {
            errorEmail="jame12@gmail.com";
            flag=false;
        }
        if (!Validate.checkPhone(phone)) {
            errorPhone ="090XXXXXXX || 091XXXXXXX";
            flag=false;
        }
        if (!flag) {
            request.setAttribute("errorCode",errorCode);
            request.setAttribute("errorEmail",errorEmail);
            request.setAttribute("errorPhone",errorPhone);
            createForm(request,response);
        } else {
            Customer customer = new Customer(id, idCustomerType, name, date, gender, idCard, phone, email, address);
            services.update(customer);
            listCustomer(request, response);
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        //int idCustomerType, String name, Date birthDay, boolean gender, String idCard, String phone, String email, String address
        Boolean status =true;
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        boolean flag =true;
        String errorCode=null;
        String errorEmail =null;
        String errorPhone =null;

        if (!Validate.checkIdCardCustomer(idCard)) {
            errorCode="9 số hoặc 12 số";
            flag=false;
        }
        if (!Validate.checkEmail(email)) {
            errorEmail="jame12@gmail.com";
            flag=false;
        }
        if (!Validate.checkPhone(phone)) {
            errorPhone ="090XXXXXXX || 091XXXXXXX";
            flag=false;
        }
        if (!flag) {
            request.setAttribute("errorCode",errorCode);
            request.setAttribute("errorEmail",errorEmail);
            request.setAttribute("errorPhone",errorPhone);
           createForm(request,response);
        }else {
            Customer customer = new Customer(idCustomerType, name, date, gender, idCard, phone, email, address,status);
            request.setAttribute("customer", customer);
            request.setAttribute("mess", "Create Success");
            services.save(customer);
            listCustomer(request, response);
        }

    }
}
