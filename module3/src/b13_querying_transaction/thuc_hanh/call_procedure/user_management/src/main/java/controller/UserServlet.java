package controller;

import bean.ArrayListSort;
import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/list", "/users"})
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;

        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        this.userService.save(user);
        showListUser(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        this.userService.update(id, name, email, country);
        showListUser(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userService.remove(id);
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userService.remove(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                User user = this.userService.findById(id);
                request.setAttribute("user", user);
                showFormUpdate(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                showListUser(request, response);
                break;
            case "sort":
                showSortedList(request, response);
                break;
            default:
                showDefault(request, response);
        }
    }

    private void showDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        if (search == null) {
            search = "";
        }
        if (search.equals("")) {
            showListUser(request, response);
        } else {
            showSearchList(request, response, search);
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = this.userService.findAll();
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    private void showSortedList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = this.userService.findAll();
        ArrayListSort arrayListSort = new ArrayListSort();
        Collections.sort(userList, arrayListSort);
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    private void showSearchList(HttpServletRequest request, HttpServletResponse response, String search) throws ServletException, IOException {
        List<User> searchList = this.userService.findByCountry(search);
        request.setAttribute("listUser", searchList);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/create.jsp").forward(request, response);
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
    }
}
