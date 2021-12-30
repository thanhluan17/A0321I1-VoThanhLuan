package com.codegym.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/user/index")
    public String user() {
        return "user";
    }

    @GetMapping("/admin/index")
    public String admin() {
        return "admin";
    }

    @GetMapping("/deny")
    public String deny() {
        return "403";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
