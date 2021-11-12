package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("hello", "xin chào");
        dictionaryMap.put("goodbye", "tạm biệt");
        dictionaryMap.put("car", "xe hơi");
        dictionaryMap.put("fan", "máy quạt");
        dictionaryMap.put("phone", "điện thoại");
    }

    @GetMapping("/dictionary")
    public String getIndex() {
        return "dictionary";
    }

    @GetMapping("/search")
    public String search(@RequestParam String word, Model model) {
        word = word.trim().toLowerCase();
        String vietnamese = dictionaryMap.get(word);
        if (vietnamese == null) {
            model.addAttribute("vietnamese", "k tim thay!");
        } else {
            model.addAttribute("vietnamese", vietnamese);
        }
        return "dictionary";
    }
}
