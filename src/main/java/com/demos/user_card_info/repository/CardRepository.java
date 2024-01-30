package com.demos.user_card_info.repository;

import com.demos.user_card_info.entity.Card;
import com.demos.user_card_info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByUser(User user);
}

