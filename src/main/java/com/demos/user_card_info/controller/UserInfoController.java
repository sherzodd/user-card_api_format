package com.demos.user_card_info.controller;

import java.util.List;
import com.demos.user_card_info.service.CardService;
import com.demos.user_card_info.service.CardTransactionService;
import com.demos.user_card_info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demos.user_card_info.model.*;
import com.demos.user_card_info.entity.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @Autowired
    private CardTransactionService cardTransactionService;


    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserInfoResponse userInfoResponse = convertToUserInfoResponse(user);

        return ResponseEntity.ok(userInfoResponse);
    }

    private UserInfoResponse convertToUserInfoResponse(User user) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setId(user.getId());
        userInfoResponse.setDob(user.getDob());
        userInfoResponse.setDt(user.getDt());
        userInfoResponse.setEmail(user.getEmail());
        userInfoResponse.setFio(user.getFio());
        userInfoResponse.setPhone(user.getPhone());
        userInfoResponse.setStatus(user.getStatus());

        List<CardInfoResponse> cardInfoResponses = new ArrayList<>();
        for (Card card : cardService.getCardsByUserId(user)) {
            CardInfoResponse cardInfoResponse = convertToCardInfoResponse(card);
            cardInfoResponses.add(cardInfoResponse);
        }
        userInfoResponse.setCards(cardInfoResponses);

        return userInfoResponse;
    }

    private CardInfoResponse convertToCardInfoResponse(Card card) {
        CardInfoResponse cardInfoResponse = new CardInfoResponse();
        cardInfoResponse.setId(card.getId());
        cardInfoResponse.setBalance(card.getBalance());
        cardInfoResponse.setCardExpire(card.getCardExpire());
        cardInfoResponse.setCardName(card.getCardName());
        cardInfoResponse.setCardNumber(card.getCardNumber());
        cardInfoResponse.setDt(card.getDt());
        cardInfoResponse.setStatus(card.getStatus());

        List<TransactionInfoResponse> transactionInfoResponses = new ArrayList<>();
        for (CardTransaction transaction : cardTransactionService.getTransactionsByCard(card)) {
            TransactionInfoResponse transactionInfoResponse = convertToTransactionInfoResponse(transaction);
            transactionInfoResponses.add(transactionInfoResponse);
        }
        cardInfoResponse.setTransactions(transactionInfoResponses);

        return cardInfoResponse;
    }

    private TransactionInfoResponse convertToTransactionInfoResponse(CardTransaction transaction) {
        TransactionInfoResponse transactionInfoResponse = new TransactionInfoResponse();
        transactionInfoResponse.setId(transaction.getId());
        transactionInfoResponse.setAmount(transaction.getAmount());
        transactionInfoResponse.setDt(transaction.getDt());
        transactionInfoResponse.setNewBalance(transaction.getNewBalance());
        transactionInfoResponse.setOldBalance(transaction.getOldBalance());
        transactionInfoResponse.setType(transaction.getType());

        return transactionInfoResponse;
    }
}
