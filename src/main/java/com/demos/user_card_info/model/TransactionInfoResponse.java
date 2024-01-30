package com.demos.user_card_info.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionInfoResponse {
    private Long id;
    private Long amount;
    private Timestamp dt;
    private Long newBalance;
    private Long oldBalance;
    private String type;
}
