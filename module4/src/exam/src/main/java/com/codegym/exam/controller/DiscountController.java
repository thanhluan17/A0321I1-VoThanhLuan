package com.codegym.exam.controller;

import com.codegym.exam.model.Discount;
import com.codegym.exam.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/discount")
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @GetMapping("/list")
    public String listDiscount(@RequestParam("key") Optional<Double> key, Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                               @RequestParam(name = "size", required = false, defaultValue = "3") int size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("title").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("title").descending();
        }
        Pageable pageable = PageRequest.of(page, size, order);
        Page<Discount> discounts;
        if (key.isPresent()) {
            discounts = discountService.findAllByDiscountAmount(key.get(), pageable);
        } else {
            discounts = discountService.findAll(pageable);
        }
        model.addAttribute("discounts", discounts);
        return "/discount/list";
    }

//    @GetMapping("/list")
//    public String listDiscount(@RequestParam("key") Optional<Double> key, @RequestParam("start") Optional<LocalDate> start, @RequestParam("end") Optional<LocalDate> end, Model model,
//                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//                               @RequestParam(name = "size", required = false, defaultValue = "3") int size,
//                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
//        Sort order = null;
//        if (sort.equals("ASC")) {
//            order = Sort.by("title").ascending();
//        } else if (sort.equals("DESC")) {
//            order = Sort.by("title").descending();
//        }
//        Pageable pageable = PageRequest.of(page, size, order);
//        Page<Discount> discounts;
//        if (key.isPresent() || start.isPresent() || end.isPresent()) {
//            discounts = discountService.findAllByDiscountAmountOrStartTimeOrEndTime(key.get(), start.get(), end.get(), pageable);
//        } else {
//            discounts = discountService.findAll(pageable);
//        }
//        model.addAttribute("discounts", discounts);
//        return "/discount/list";
//    }

    @GetMapping("/create")
    public String createDiscount(Model model) {
        model.addAttribute("discount", new Discount());
        return "/discount/create";
    }

    @PostMapping("/create")
    public String saveDiscount(@Valid @ModelAttribute Discount discount,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/discount/create";
        }
        discountService.save(discount);
        redirectAttributes.addFlashAttribute("message", "Add success discount: "
                + discount.getTitle());
        return "redirect:/discount/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id, Model model) {
        Discount discount = discountService.findById(id);
        model.addAttribute("discount", discount);
        return "discount/delete";
    }

    @PostMapping("/actionDelete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        discountService.remove(id);
        return "redirect:/discount/list";
    }
}
