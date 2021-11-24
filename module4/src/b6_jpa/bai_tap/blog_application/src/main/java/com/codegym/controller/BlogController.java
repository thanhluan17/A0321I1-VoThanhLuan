package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String blogDetail(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Saved successfully");
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Blog blog) {
        blogService.remove(blog.getId());
        System.out.println(blog.getId());
        return "redirect:/list";
    }
}
