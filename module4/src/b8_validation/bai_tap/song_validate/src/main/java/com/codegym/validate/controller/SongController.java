package com.codegym.validate.controller;

import com.codegym.validate.model.Song;
import com.codegym.validate.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/list")
    public String listSong(Model model) {
        Iterable<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String addSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        songService.save(song);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("song", song);
            return "edit";
        }
        songService.save(song);
        return "redirect:/list";
    }
}
