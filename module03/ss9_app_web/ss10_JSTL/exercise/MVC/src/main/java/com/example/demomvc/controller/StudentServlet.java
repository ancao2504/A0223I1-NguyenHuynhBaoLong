package com.example.demomvc.controller;

import com.example.demomvc.model.Student;
import com.example.demomvc.service.IStudentService;
import com.example.demomvc.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                System.out.println("chạy vô create");
                showFormCreate(request, response);
                break;
            case "edit":
                System.out.println("---------id----------");
                updateStudentForm(request, response);
                break;
            case "delete":
                break;
            default:
                System.out.println("chạy xuống default");
                listStudents(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "edit":
                updateStudent(request, response);
                break;
            case "delete":
                break;
            default:
                listStudents(request,response);
                break;
        }
    }



    private void listStudents(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = this.studentService.findAll();
        request.setAttribute("students",students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println("error server");
        } catch (IOException e) {
            System.out.println("error");
        }
    }


    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println("error server");
        } catch (IOException e) {
            System.out.println("error");
        }
    }


    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int iD = Integer.parseInt(request.getParameter("id"));
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        double point = Integer.parseInt(request.getParameter("point"));

        Student student = new Student(iD, name, gender, point);
        this.studentService.save(student);
        listStudents(request,response);

    }

    private void updateStudentForm(HttpServletRequest request, HttpServletResponse response) {
        int ID = Integer.parseInt(request.getParameter("id"));
        System.out.println(ID);
        Student student =this.studentService.findById(ID);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println("error server");
        } catch (IOException e) {
            System.out.println("error");
        }
    }


    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int iD = Integer.parseInt(request.getParameter("id"));
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        double point = Integer.parseInt(request.getParameter("point"));

        Student student =this.studentService.findById(iD);
        student.setId(iD);
        student.setName(name);
        student.setGender(gender);
        student.setPoint(point);
        this.studentService.update(iD,student);
        request.setAttribute("student",student);
        request.setAttribute("message", "student information was updated");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
