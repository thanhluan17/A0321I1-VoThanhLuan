package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String showList(@RequestParam("word") Optional<String> word, Model model,
                           @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(name = "size", required = false, defaultValue = "2") int size,
                           @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort order = null;
        if(sort.equals("ASC")){
            order = Sort.by("createDate").ascending();
        }else if (sort.equals("DESC")){
            order = Sort.by("createDate").descending();
        }
        Pageable pageable = PageRequest.of(page, size, order);
        Page<Blog> blogs;
        if (word.isPresent()) {
            blogs = blogService.findAllByTitleContaining(word.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }

    @GetMapping("/list-more")
    public String showAll(Model model, Pageable pageable) {
        Page<Blog> blogs;
            blogs = blogService.findAll(pageable);
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }

    @GetMapping("/detail/{id}")
    public String blogDetail(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/detail";
    }

    @GetMapping("/user/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @GetMapping("/user/edit/{id}")
    public String editBlog(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/user/save")
    public String saveBlog(@ModelAttribute Blog blog, Model model) {
        blogService.save(blog);
        model.addAttribute("message", "Saved successfully");
        return "redirect:/blog/list";
    }

    @GetMapping("/user/delete/{id}")
    public String showDelete(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/delete";
    }

    @PostMapping("/user/delete")
    public String deleteCustomer(@ModelAttribute Blog blog) {
        blogService.remove(blog.getBlogId());
        return "redirect:/blog/list";
    }

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

}
