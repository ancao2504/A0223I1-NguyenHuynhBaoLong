package com.example.casestudy.controller;

import com.example.casestudy.model.Service;
import com.example.casestudy.service.IService;
import com.example.casestudy.service.impl.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/service-servlet")
public class ServiceServlet extends HttpServlet {
    private IService iService = new ServiceImpl();
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
//            case "edit":
//                editForm(request, response);
//                break;
//            case "delete":
//                deleteForm(request, response);
//                break;
            default:
                listService(request, response);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> services = iService.findAll();
        request.setAttribute("services",services);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("service/list.jsp");
        try {
            requestDispatcher.forward(request,response);
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
//            case "edit":
//                edit(request, response);
//                break;
//            case "delete":
//                delete(request, response);
//                break;
//            case "search":
//                search(request, response);
//                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
            String name = request.getParameter("name");
             int area = Integer.parseInt(request.getParameter("area"));
             double fee = Double.parseDouble(request.getParameter("fee"));
             int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
             int idRentType= Integer.parseInt(request.getParameter("idRentType"));
             int idTypeService = Integer.parseInt(request.getParameter("idTypeService"));
             String standardRoom = request.getParameter("standardRoom");
            String description = request.getParameter("description");
             double areaPool = Double.parseDouble(request.getParameter("areaPool"));
             int floor = Integer.parseInt(request.getParameter("floor"));
             Service service =new Service(name, area, fee, maxPeople, idRentType, idTypeService, standardRoom,
                     description, areaPool, floor);
             iService.save(service);
             listService(request, response);
    }
}
