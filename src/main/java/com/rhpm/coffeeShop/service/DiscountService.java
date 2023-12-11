package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;

public interface DiscountService {
    DiscountResponseDto createDiscount(DiscountRequestDto discountRequestDto);
}
