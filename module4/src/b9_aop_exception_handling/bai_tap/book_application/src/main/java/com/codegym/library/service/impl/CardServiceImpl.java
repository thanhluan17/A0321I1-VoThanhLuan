package com.codegym.library.service.impl;

import com.codegym.library.model.Card;
import com.codegym.library.repository.BookRepository;
import com.codegym.library.repository.CardRepository;
import com.codegym.library.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findById(int id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public Card save(Card borrowCard) {
        return cardRepository.save(borrowCard);
    }

    @Override
    public void delete(int id) {
        cardRepository.deleteById(id);
    }
}
