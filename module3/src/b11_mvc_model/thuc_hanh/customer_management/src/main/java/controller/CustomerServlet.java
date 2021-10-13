package controller;

import entity.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/list", "/customers"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name;
        String email;
        String address;
        int id;
        switch (action) {
            case "create":
                name = request.getParameter("name");
                email = request.getParameter("email");
                address = request.getParameter("address");
                if (name.equals("")) {
                    System.out.println("Invalid name!");
                    return;
                }
                id = (int) (Math.random() * 10000);
                Customer createCustomer = new Customer(id, name, email, address);
                this.customerService.save(createCustomer);
                response.sendRedirect("/customers");
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                email = request.getParameter("email");
                address = request.getParameter("address");
                this.customerService.update(id, name, email, address);
                response.sendRedirect("/customers");
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                this.customerService.remove(id);
                response.sendRedirect("/customers");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        int id;
        switch (action) {
            case "create":
                request.getRequestDispatcher("customer/create.jsp").forward(request, response);
                break;
            case "view":
                id = Integer.parseInt(request.getParameter("id"));
                Customer viewCustomer = this.customerService.findById(id);
                request.setAttribute("customer", viewCustomer);
                request.getRequestDispatcher("customer/view.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                Customer editCustomer = this.customerService.findById(id);
                request.setAttribute("customer", editCustomer);
                request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                Customer deleteCustomer = this.customerService.findById(id);
                request.setAttribute("customer", deleteCustomer);
                request.getRequestDispatcher("customer/delete.jsp").forward(request, response);
                break;
            default:
                List<Customer> customers = this.customerService.findAll();
                request.setAttribute("customerListServlet", customers);
                request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        }
    }
}
