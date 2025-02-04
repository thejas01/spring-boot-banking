package com.thejas.banking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.*;
import java.math.BigDecimal;



@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String type; // DEPOSIT, WITHDRAWAL, TRANSFER

    @ManyToOne
    private Account account;

    @ManyToOne
    private Account recipient; // For transfers
}
