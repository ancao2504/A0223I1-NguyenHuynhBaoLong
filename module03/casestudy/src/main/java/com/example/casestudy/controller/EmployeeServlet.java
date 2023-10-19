package com.example.casestudy.controller;

import com.example.casestudy.common.Validate;
import com.example.casestudy.model.*;
import com.example.casestudy.service.IEmployeeService;
import com.example.casestudy.service.IServiceId;
import com.example.casestudy.service.impl.DivisionService;
import com.example.casestudy.service.impl.EmployeeServiceImpl;
import com.example.casestudy.service.impl.LevelService;
import com.example.casestudy.service.impl.PositionServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee-servlet")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService services =new EmployeeServiceImpl();
    private IServiceId<Position> iposition =new PositionServiceImpl();
    private IServiceId<EducationDegree> levelService =new LevelService();
    private IServiceId<Division> divisionService = new DivisionService();
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
        List<Position> positions = iposition.findAll();
        List<EducationDegree> educationDegrees = levelService.findAll();
        List<Division> divisions = divisionService.findAll();
        request.setAttribute("employees",employees);
        request.setAttribute("positions",positions);
        request.setAttribute("educationDegrees",educationDegrees);
        request.setAttribute("divisions",divisions);
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
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = services.findById(id);
        System.out.println("-------id------------"+id+"------employee---"+employee);
        request.setAttribute("employee",employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/delete.jsp");
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
        Employee employee = services.findById(id);
        List<Position> positions = iposition.findAll();
        List<EducationDegree> educationDegrees = levelService.findAll();
        List<Division> divisions = divisionService.findAll();
        request.setAttribute("positions",positions);
        request.setAttribute("educationDegrees",educationDegrees);
        request.setAttribute("divisions",divisions);
        request.setAttribute("employee",employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positions = iposition.findAll();
        List<EducationDegree> educationDegrees = levelService.findAll();
        List<Division> divisions = divisionService.findAll();
        request.setAttribute("positions",positions);
        request.setAttribute("educationDegrees",educationDegrees);
        request.setAttribute("divisions",divisions);
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
            case "search":
                search(request, response);
                break;
            case "check" :
                check(request,response);
                break;

        }
    }

    private void check(HttpServletRequest request, HttpServletResponse response) {
        String errorLogin =null;
       String userName= request.getParameter("userName");
       String password= request.getParameter("password");
        User user = new User(userName, password);
       if (services.checkUser(user)){
           request.setAttribute("userName",user.getUserName());
           RequestDispatcher requestDispatcher= request.getRequestDispatcher("main.jsp");
           try {
               requestDispatcher.forward(request, response);
           } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       } else {
           errorLogin="pass or user name not correct";
           request.setAttribute("errorLogin",errorLogin);
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
           try {
               requestDispatcher.forward(request,response);
           } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> employees = services.findByName(name);
        List<Position> positions = iposition.findAll();
        List<EducationDegree> educationDegrees = levelService.findAll();
        List<Division> divisions = divisionService.findAll();
        request.setAttribute("positions",positions);
        request.setAttribute("educationDegrees",educationDegrees);
        request.setAttribute("divisions",divisions);
        request.setAttribute("employees",employees);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("employee/search.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
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
        Employee employee = new Employee( idCard, name, date, salary, phone, email, address, idPosition,
                idEducationDegree, idDivision, userName);
        services.delete(employee);
        request.setAttribute("mess","Delete Success");
        listEmployee(request,response);

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("---------id------"+id);
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
        Employee employee = new Employee( id,idCard, name, date, salary, phone, email, address, idPosition,
                idEducationDegree, idDivision, userName);
        services.update(employee);
        request.setAttribute("mess","Update Success");
        listEmployee(request,response);
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
        String errorEmail =null;
        String errorPhone =null;
        String errorSalary=null;
        Boolean flag =true;
        if (salary < 0) {
            errorSalary = "salary > 0";
            flag = false;
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
            request.setAttribute("errorEmail", errorEmail);
            request.setAttribute("errorPhone", errorPhone);
            request.setAttribute("errorSalary", errorSalary);
        } else {
            Employee employee = new Employee( idCard, name, date, salary, phone, email, address, idPosition,
                    idEducationDegree, idDivision, userName);
            services.save(employee);
            request.setAttribute("mess", "Create Success");
            listEmployee(request,response);
        }

    }
}
