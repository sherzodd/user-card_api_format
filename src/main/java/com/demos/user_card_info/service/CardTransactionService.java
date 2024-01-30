package com.demos.user_card_info.service;

import com.demos.user_card_info.entity.Card;
import com.demos.user_card_info.entity.CardTransaction;
import com.demos.user_card_info.repository.CardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardTransactionService {

    @Autowired
    private CardTransactionRepository cardTransactionRepository;

    public List<CardTransaction> getTransactionsByCard(Card card){
        return cardTransactionRepository.findAllByCard(card);
    }
}
