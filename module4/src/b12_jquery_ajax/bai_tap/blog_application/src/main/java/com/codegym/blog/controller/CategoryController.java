package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public String categoryList(Model model) {
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String saveCategory(@ModelAttribute Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("category", new Category());
        model.addAttribute("message", "New category saved successfully");
        return "category/create";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Category category, Model model) {
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("/edit")
    public String updateCategory(@ModelAttribute Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("category", category);
        model.addAttribute("message", "Category updated successfully");
        return "/category/edit";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Category category, Model model) {
        model.addAttribute("category", category);
        return "/category/delete";
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute Category category) {
        categoryService.remove(category.getCateId());
        return "redirect:/category/list";
    }

    @GetMapping("/view/{id}")
    public String viewCategory(@PathVariable("id") Category category, Model model) {
        Iterable<Blog> blogs = blogService.findAllByCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("blogs", blogs);
        return "/category/view";
    }
}
