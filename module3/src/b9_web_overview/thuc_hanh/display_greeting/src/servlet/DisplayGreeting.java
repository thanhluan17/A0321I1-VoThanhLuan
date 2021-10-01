package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayGreeting", urlPatterns = "/login")
public class DisplayGreeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        if ("luan".equals(user) && "luan".equals(pass)) {
            out.println("<h1>Welcome " + user + " to website</h1>");
        } else {
            out.println("<h1>Login Error</h1>");
        }

        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
