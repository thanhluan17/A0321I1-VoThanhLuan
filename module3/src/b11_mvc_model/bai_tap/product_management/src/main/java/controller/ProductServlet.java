package controller;

import entity.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/list", "/products"})
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id, name, description, producer;
        double price;
        switch (action) {
            case "create":
                id = request.getParameter("id");
                name = request.getParameter("name");
                price = Double.parseDouble(request.getParameter("price"));
                description = request.getParameter("description");
                producer = request.getParameter("producer");
                if (name.equals("")) {
                    System.out.println("Invalid name!");
                    return;
                }
                Product createProduct = new Product(id, name, price, description, producer);
                this.productService.save(createProduct);
                response.sendRedirect("/products");
                break;
            case "edit":
                id = request.getParameter("id");
                name = request.getParameter("name");
                price = Double.parseDouble(request.getParameter("price"));
                description = request.getParameter("description");
                producer = request.getParameter("producer");
                this.productService.update(id, name, price, description, producer);
                response.sendRedirect("/products");
                break;
            case "delete":
                id = request.getParameter("id");
                this.productService.remove(id);
                response.sendRedirect("/products");
                break;
            case "search":
                String searchStr = request.getParameter("searchStr");
                List<Product> searchList = this.productService.findByName(searchStr);
                request.setAttribute("productList", searchList);
                request.getRequestDispatcher("product/search_rs.jsp").forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        String id;
        switch (action) {
            case "create":
                request.getRequestDispatcher("product/create.jsp").forward(request, response);
                break;
            case "view":
                id = request.getParameter("id");
                Product viewProduct = this.productService.findById(id);
                request.setAttribute("product", viewProduct);
                request.getRequestDispatcher("product/view.jsp").forward(request, response);
                break;
            case "edit":
                id = request.getParameter("id");
                Product editProduct = this.productService.findById(id);
                request.setAttribute("product", editProduct);
                request.getRequestDispatcher("product/edit.jsp").forward(request, response);
                break;
            case "delete":
                id = request.getParameter("id");
                Product deleteProduct = this.productService.findById(id);
                request.setAttribute("product", deleteProduct);
                request.getRequestDispatcher("product/delete.jsp").forward(request, response);
                break;
            case "search":
                request.getRequestDispatcher("product/search.jsp").forward(request, response);
                break;
            case "list":
                List<Product> products = this.productService.findAll();
                request.setAttribute("productList", products);
                request.getRequestDispatcher("product/list.jsp").forward(request, response);
                break;
        }
    }
}
