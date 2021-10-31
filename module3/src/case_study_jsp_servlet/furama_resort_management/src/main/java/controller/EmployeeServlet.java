package controller;

import model.bean.employee.Division;
import model.bean.employee.Education;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.service.DivisionService;
import model.service.EducationService;
import model.service.EmployeeService;
import model.service.PositionService;
import model.service.impl.DivisionServiceImpl;
import model.service.impl.EducationServiceImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    PositionService positionService = new PositionServiceImpl();
    EducationService educationService = new EducationServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position"));
        int educationId = Integer.parseInt(request.getParameter("education"));
        int divisionId = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, positionId, educationId, divisionId);
        Map<String, String> mapMessage = employeeService.create(employee);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("errBirthday", mapMessage.get("birthday"));
            request.setAttribute("errIdCard", mapMessage.get("idCard"));
            request.setAttribute("errSalary", mapMessage.get("salary"));
            request.setAttribute("errPhone", mapMessage.get("phone"));
            request.setAttribute("errEmail", mapMessage.get("email"));
            request.setAttribute("createEmployee", employee);
            try {
                showCreateForm(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                showListEmployee(request, response);
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
                showCreateForm(request, response);
                break;
            default:
                try {
                    showListEmployee(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.findAll();
        List<Education> educationList = educationService.findAll();
        List<Division> divisionList = divisionService.findAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("divisionList", divisionList);
        request.getRequestDispatcher("/furama/employee/create.jsp").forward(request, response);
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("/furama/employee/list.jsp").forward(request, response);
    }
}
