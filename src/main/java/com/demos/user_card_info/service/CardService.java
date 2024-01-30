package com.demos.user_card_info.service;

import com.demos.user_card_info.entity.Card;
import com.demos.user_card_info.entity.User;
import com.demos.user_card_info.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    public List<Card> getCardsByUserId(User user) {
        return cardRepository.findAllByUser(user);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }
}
