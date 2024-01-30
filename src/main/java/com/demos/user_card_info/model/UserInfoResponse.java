package com.demos.user_card_info.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserInfoResponse {
    private Long id;
    private LocalDate dob;
    private Timestamp dt;
    private String email;
    private String fio;
    private Long phone;
    private int status;
    private List<CardInfoResponse> cards;
}
