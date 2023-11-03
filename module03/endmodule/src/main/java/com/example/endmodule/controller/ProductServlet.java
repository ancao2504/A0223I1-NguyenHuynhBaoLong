package com.example.endmodule.controller;

import com.example.endmodule.model.Category;
import com.example.endmodule.model.Color;
import com.example.endmodule.model.Product;
import com.example.endmodule.service.ICategoryService;
import com.example.endmodule.service.IColorService;
import com.example.endmodule.service.IProductService;
import com.example.endmodule.service.impl.CategoryServiceImpl;
import com.example.endmodule.service.impl.ColorServiceImpl;
import com.example.endmodule.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();
    private ICategoryService categoryService = new CategoryServiceImpl();
    private IColorService colorService = new ColorServiceImpl();

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
            case "update":
                updateForm(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int idColor = Integer.parseInt(request.getParameter("color"));
        int idCategory = Integer.parseInt(request.getParameter("category"));
        Color color = colorService.findById(idColor);
        Category category = categoryService.findById(idCategory);
        Product product = productService.findById(id);
        request.setAttribute("category", category);
        request.setAttribute("color", color);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories = categoryService.findAll();
        List<Color> colors = colorService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("colors", colors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();
        List<Color> colors = colorService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("products", products);
        request.setAttribute("colors", colors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
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
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request,response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        List<Product> products = productService.search(name,price);
        request.setAttribute("products",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        productService.delete(id);
        listProduct(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int idColor = Integer.parseInt(request.getParameter("color"));
        Color color = colorService.findById(idColor);
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.findById(idCategory);
        Boolean status = true;
        Product product = new Product(id, name, price, quantity, color, description, category, status);
        productService.update(product);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int idColor = Integer.parseInt(request.getParameter("color"));
        Color color = colorService.findById(idColor);
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.findById(idCategory);
        Boolean status = true;
        Boolean flag = true;
        String errorPrice ="";
        String errorQuantity ="";
        if (price <10000){
            flag=false;
            errorPrice="price >10000";
        }
        if (quantity <=0) {
            flag=false;
            errorQuantity="quantity >0";
        }
        if (flag) {
            Product product = new Product(name, price, quantity, color, description, category, status);
            productService.save(product);
            listProduct(request, response);
        }
        else {
            request.setAttribute("errorPrice",errorPrice);
            request.setAttribute("errorQuantity",errorQuantity);
            createForm(request, response);
        }

    }
}
