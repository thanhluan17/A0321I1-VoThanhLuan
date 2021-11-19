package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmaliBoxController {
    @GetMapping("/configuration")
    public String showConfig(Model model) {
        EmailBox config = new EmailBox("Vietnamese", 25, false, "Naul");
        model.addAttribute("languageList", EmailService.languageList);
        model.addAttribute("pageSizeList", EmailService.pageSizeList);
        model.addAttribute("config", config);
        return "configuration";
    }

    @PostMapping("/info")
    public String updateConfig(@ModelAttribute EmailBox config, Model model) {
        model.addAttribute("languageList", EmailService.languageList);
        model.addAttribute("pageSizeList", EmailService.pageSizeList);
        model.addAttribute("config", config);
        return "showSetting";
    }

    @PostMapping("/change")
    public String changeConfig(@ModelAttribute EmailBox config, Model model) {
        model.addAttribute("languageList", EmailService.languageList);
        model.addAttribute("pageSizeList", EmailService.pageSizeList);
        model.addAttribute("config", config);
        return "configuration";
    }
}
