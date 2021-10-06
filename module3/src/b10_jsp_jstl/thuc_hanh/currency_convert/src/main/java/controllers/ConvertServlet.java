package controllers;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "ConvertServlet", urlPatterns = "/convert")
public class ConvertServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = rate * usd;

        request.setAttribute("usd", usd);
        request.setAttribute("vnd", vnd);
        request.getRequestDispatcher("convert.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
