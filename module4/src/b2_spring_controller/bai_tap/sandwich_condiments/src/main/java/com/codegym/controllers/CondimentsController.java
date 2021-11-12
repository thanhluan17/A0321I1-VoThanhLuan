package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentsController {
    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("index");
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "index";
    }
}
