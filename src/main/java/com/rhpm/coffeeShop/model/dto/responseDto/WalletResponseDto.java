package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class WalletResponseDto {
    private Long id;
    private Double balance;
    private Long userId;
    private List<TransactionResponseDto> transaction;
}
