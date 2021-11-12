package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/convert")
    public String convert(@RequestParam String usd, Model model) {
        double vnd = Double.parseDouble(usd) * 23000;
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
