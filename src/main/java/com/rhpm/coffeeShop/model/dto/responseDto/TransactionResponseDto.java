package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionResponseDto {
    private Long id;
    private Date transactionDate;
    private double amount;
    private String description;
    private Long walletId;
}
