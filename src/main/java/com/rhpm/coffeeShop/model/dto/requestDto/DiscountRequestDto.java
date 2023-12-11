package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;

@Data
public class DiscountRequestDto {
    private String code;
    private Long userCreateId;
}
