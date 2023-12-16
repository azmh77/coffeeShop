package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;

@Data
public class OldEmailRequestDto {
    private String newEmail;
    private Long userId;
}
