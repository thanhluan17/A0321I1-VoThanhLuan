package controllers;

import models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/list"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("001", "Võ Thành Luân", "17/01/2000", "Quảng Ngãi", "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg"));
        customers.add(new Customer("002", "Trần Minh Khoa", "10/10/2000", "Quảng Nam", "http://cdnexpatwomanfood.expatwoman.com/s3fs-public/bigstock-Pink-Grapefruit-50293616.jpg"));
        customers.add(new Customer("003", "Huỳnh Thanh Xuyến", "11/11/2000", "Đà Nẵng", "https://images.kitchenstories.io/wagtailOriginalImages/A994-photo-content-15.jpg"));

        request.setAttribute("customerList", customers);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
