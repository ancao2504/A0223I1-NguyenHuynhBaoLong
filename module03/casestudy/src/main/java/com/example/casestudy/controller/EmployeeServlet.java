package com.example.casestudy.controller;

import com.example.casestudy.model.Employee;
import com.example.casestudy.service.IEmployeeService;
import com.example.casestudy.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee-servlet")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService services =new EmployeeServiceImpl();
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
                listEmployee(request, response);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = services.findAll();
        request.setAttribute("employees",employees);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/create.jsp");
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
                create(request,response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;

        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        //                int id, int idCard, String name, Date birthDay, double salary, String phone, String email,
//                    String address, int idPosition, int idEducationDegree, int idDivision, String userName) {
        String idCard = (request.getParameter("idCard"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        Date date = Date.valueOf(birthDay);
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("idPosition"));
        int idEducationDegree = Integer.parseInt(request.getParameter("idEducationDegree"));
        int idDivision = Integer.parseInt(request.getParameter("idDivision"));
        String userName = request.getParameter("userName");
        //employee = new Employee(id, idCard, name, date, salary, phone, email, address, idPosition,
        //                        idEducationDegree, idDivision, userName);
        Employee employee = new Employee( idCard, name, date, salary, phone, email, address, idPosition,
                                        idEducationDegree, idDivision, userName);
        services.save(employee);
        listEmployee(request,response);
    }
}
