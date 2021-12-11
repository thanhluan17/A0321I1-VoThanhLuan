package com.codegym.cart.controller;

import com.codegym.cart.model.Product;
import com.codegym.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Map<Product, Integer> setUpCart() {
        return new LinkedHashMap<>();
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/list";
    }

    @GetMapping("/detail")
    public String detailProduct(@RequestParam Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Map<Product, Integer> cart, Model model, @RequestParam(defaultValue = "0") Integer id) {
        int amount = 0;
        Set<Product> keySet = cart.keySet();
        for (Product key : keySet) {
            amount += key.getPrice() * cart.get(key);
        }
        model.addAttribute("id", id);
        model.addAttribute("amount", amount);
        return "cart";
    }

    @GetMapping("/addCart")
    public String addCart(@ModelAttribute("cart") Map<Product, Integer> cart, @RequestParam Integer id, @RequestParam int quantity) {
        Product product = productService.findById(id);
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product), cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
        return "redirect:/cart";
    }

    @GetMapping("/updateCart")
    public String updateCart(@ModelAttribute("cart") Map<Product, Integer> cart, @RequestParam int id, @RequestParam int quantity) {
        Product item = productService.findById(id);
        cart.replace(item, cart.get(item), quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteCart(@ModelAttribute("cart") Map<Product, Integer> cart, @RequestParam(defaultValue = "0") int id) {
        System.out.println(id);
        if (id == 0) {
            cart.clear();
        } else {
            Product item = productService.findById(id);
            if (item != null) {
                cart.remove(item, cart.get(item));
                Set<Product> set = cart.keySet();
                for (Product key : set) {
                    System.out.println(key + " " + cart.get(key));
                }
            }
        }
        return "redirect:/cart";
    }
}
