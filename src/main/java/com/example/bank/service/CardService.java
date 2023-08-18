package com.example.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Card;
import com.example.bank.repository.CardRepository;

@Service
public class CardService {
    
	@Autowired
	private CardRepository cardRepository;

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    // Implement update method if needed
}
