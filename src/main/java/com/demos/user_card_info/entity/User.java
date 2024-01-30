package com.demos.user_card_info.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "dt", columnDefinition = "TIMESTAMP DEFAULT current_timestamp")
    private Timestamp dt;

}
