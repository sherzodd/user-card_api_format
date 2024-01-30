package com.demos.user_card_info.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "card_type", columnDefinition = "VARCHAR(3) CHECK (card_type IN ('uz', 'hum'))")
    private String cardType;

    @Column(name = "card_number", length = 20)
    private String cardNumber;

    @Column(name = "card_expire", length = 7)
    private String cardExpire;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "status")
    private Integer status;

    @Column(name = "dt", columnDefinition = "TIMESTAMP DEFAULT current_timestamp")
    private Timestamp dt;
}
