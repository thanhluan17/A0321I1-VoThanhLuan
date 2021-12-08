package com.codegym.library.controller;

import com.codegym.library.model.Book;
import com.codegym.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book/list")
    public ModelAndView showBookList() {
        return new ModelAndView("book/list", "books", bookService.findAll());
    }

    @GetMapping("/book/new")
    public ModelAndView showBookForm() {
        return new ModelAndView("book/create", "book", new Book());
    }

    @PostMapping("/book/save")
    public String addNewBook(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/create";
        }
        bookService.save(book);
        return "redirect:/book/list";
    }
}
