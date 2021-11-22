package com.codegym.controller;

import com.codegym.model.PictureData;
import com.codegym.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PictureController {
    @Autowired
    PictureService pictureService;

    @GetMapping("/")
    public String index(Model model) {
        List<PictureData> dataList = pictureService.findAll();
        model.addAttribute("dataList", dataList);
        model.addAttribute("data", new PictureData());
        return "index";
    }

    @PostMapping("/rate")
    public String rate(@ModelAttribute PictureData data){
        pictureService.save(data);
        return "redirect:/";
    }
}
