package controller;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.service.customer.CustomerService;
import model.service.customer.CustomerTypeService;
import model.service.customer.impl.CustomerServiceImpl;
import model.service.customer.impl.CustomerTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        Map<String, String> mapMessage = customerService.edit(customer);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("errBirthday", mapMessage.get("birthday"));
            request.setAttribute("errIdCard", mapMessage.get("idCard"));
            request.setAttribute("errPhone", mapMessage.get("phone"));
            request.setAttribute("errEmail", mapMessage.get("email"));
            request.setAttribute("customer", customer);
            try {
                showCreateForm(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                showListCustomer(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(typeId, name, birthday, gender, idCard, phone, email, address);
        Map<String, String> mapMessage = customerService.create(customer);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("errBirthday", mapMessage.get("birthday"));
            request.setAttribute("errIdCard", mapMessage.get("idCard"));
            request.setAttribute("errPhone", mapMessage.get("phone"));
            request.setAttribute("errEmail", mapMessage.get("email"));
            request.setAttribute("customer", customer);
            try {
                showCreateForm(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                showListCustomer(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showCreateForm(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    showUpdateForm(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchCustomer(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListCustomer(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        List<Customer> customerList = customerService.findByContainName(key);
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/furama/customer/list.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        request.setAttribute("customerTypes", customerTypes);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/furama/customer/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        request.setAttribute("customerTypes", customerTypes);
        request.getRequestDispatcher("/furama/customer/create.jsp").forward(request, response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/furama/customer/list.jsp").forward(request, response);
    }
}

