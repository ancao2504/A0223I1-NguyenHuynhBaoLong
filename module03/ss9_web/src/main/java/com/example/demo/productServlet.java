package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "productServlet", value = "/productServlet")
public class productServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("price"));
        System.out.println("---------price-------"+price);
        double percent = Double.parseDouble(request.getParameter("percent"));
        double discount = price * percent * 0.01;
        request.setAttribute("discount",discount);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");

        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
