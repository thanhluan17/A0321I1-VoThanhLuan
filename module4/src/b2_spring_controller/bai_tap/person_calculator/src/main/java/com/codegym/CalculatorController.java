package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String numA, @RequestParam String numB, @RequestParam String operator, Model model) {
        double result = 0;
        double a = Double.parseDouble(numA);
        double b = Double.parseDouble(numB);
        switch (operator) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mul":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
