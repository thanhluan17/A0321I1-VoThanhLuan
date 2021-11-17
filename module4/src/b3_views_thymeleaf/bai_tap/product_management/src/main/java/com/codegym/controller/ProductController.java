package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/product")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/product/save")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String createProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/product/{id}/edit")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model) {
        productService.remove(id);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }
}
