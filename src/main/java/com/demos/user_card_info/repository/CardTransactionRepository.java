package com.demos.user_card_info.repository;

import com.demos.user_card_info.entity.Card;
import com.demos.user_card_info.entity.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTransactionRepository extends JpaRepository<CardTransaction, Long> {

    List<CardTransaction> findAllByCard(Card card);
}
