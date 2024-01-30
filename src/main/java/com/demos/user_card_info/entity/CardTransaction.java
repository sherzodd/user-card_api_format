package com.demos.user_card_info.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "cards_transactions")
public class CardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "type", columnDefinition = "VARCHAR(6) CHECK (type IN ('debit', 'credit'))")
    private String type;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "old_balance")
    private Long oldBalance;

    @Column(name = "new_balance")
    private Long newBalance;

    @Column(name = "dt", columnDefinition = "TIMESTAMP DEFAULT current_timestamp")
    private Timestamp dt;
}
