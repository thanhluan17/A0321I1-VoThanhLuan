package com.codegym.library.service;

import com.codegym.library.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    List<Card> findAll();

    Card findById(int id);

    Card save(Card card);

    void delete(int id);
}
