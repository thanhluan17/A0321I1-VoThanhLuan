package controller;

import model.bean.employee.Division;
import model.bean.employee.Education;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.service.employee.DivisionService;
import model.service.employee.EducationService;
import model.service.employee.EmployeeService;
import model.service.employee.PositionService;
import model.service.employee.impl.DivisionServiceImpl;
import model.service.employee.impl.EducationServiceImpl;
import model.service.employee.impl.EmployeeServiceImpl;
import model.service.employee.impl.PositionServiceImpl;

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
                createEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
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
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationId, divisionId);
        Map<String, String> mapMessage = employeeService.edit(employee);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("errBirthday", mapMessage.get("birthday"));
            request.setAttribute("errIdCard", mapMessage.get("idCard"));
            request.setAttribute("errSalary", mapMessage.get("salary"));
            request.setAttribute("errPhone", mapMessage.get("phone"));
            request.setAttribute("errEmail", mapMessage.get("email"));
            request.setAttribute("employee", employee);
            try {
                showUpdateForm(request, response);
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

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
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
                    searchEmployee(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListEmployee(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        List<Employee> employeeList = employeeService.findByContainName(key);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("/furama/employee/list.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        List<Position> positionList = positionService.findAll();
        List<Education> educationList = educationService.findAll();
        List<Division> divisionList = divisionService.findAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/furama/employee/edit.jsp").forward(request, response);
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
