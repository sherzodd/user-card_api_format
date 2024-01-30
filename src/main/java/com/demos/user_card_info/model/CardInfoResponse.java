package com.demos.user_card_info.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CardInfoResponse {
    private Long id;
    private Long balance;
    private String cardExpire;
    private String cardName;
    private String cardNumber;
    private Timestamp dt;
    private int status;
    private List<TransactionInfoResponse> transactions;
}