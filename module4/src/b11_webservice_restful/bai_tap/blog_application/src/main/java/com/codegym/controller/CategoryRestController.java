package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/api/category/list")
    public ResponseEntity<Iterable<Category>> categoryList() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<Iterable<Category>>(categories, HttpStatus.OK);
    }
}
