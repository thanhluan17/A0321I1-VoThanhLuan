package com.codegym.library.controller;

import com.codegym.library.exception.BookException;
import com.codegym.library.exception.CardException;
import com.codegym.library.model.Book;
import com.codegym.library.model.Card;
import com.codegym.library.service.BookService;
import com.codegym.library.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CardController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CardService cardService;

    @GetMapping("/card/list")
    public ModelAndView borrowList() {
        return new ModelAndView("card/list", "card", cardService.findAll());
    }

    @GetMapping("/card/view/{id}")
    public ModelAndView viewBorrowCard(@PathVariable int id) {
        return new ModelAndView("card/detail", "card", cardService.findById(id));
    }

    @GetMapping("/card/{id}")
    public String borrowBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws BookException {
        Card card = new Card();
        Book book = bookService.findById(id);
        if (book == null || book.getQty() == 0) {
            throw new BookException();
        } else {
            book.setQty(book.getQty() - 1);
            bookService.save(book);
            int borrowCardId = (int) (Math.random() * (99999 - 10000) + 10000);
            card.setId(borrowCardId);
            card.setBook(book);
            card = cardService.save(card);
        }
        redirectAttributes.addFlashAttribute("message", "Mượn sách thành công");
        return "redirect:/card/view/" + card.getId();
    }

    @GetMapping("/return")
    public ModelAndView returnBook(@RequestParam int cardId) {
        ModelAndView modelAndView = new ModelAndView("card/detail");
        Card card = cardService.findById(cardId);
        Book book = card.getBook();
        book.setQty(book.getQty() + 1);
        cardService.delete(cardId);
        bookService.save(book);
        modelAndView.addObject("message", "Trả sách thành công");
        return modelAndView;
    }

    @ExceptionHandler(CardException.class)
    public ModelAndView showErrorPage() {
        return new ModelAndView("card/error");
    }

    @ExceptionHandler(BookException.class)
    public ModelAndView showBookErrorPage() {
        return new ModelAndView("book/error");
    }
}
