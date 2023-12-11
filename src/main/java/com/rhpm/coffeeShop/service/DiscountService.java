package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

import java.io.IOException;

public interface DiscountService {
    DiscountResponseDto createDiscount(DiscountRequestDto discountRequestDto) throws MasterException, IOException;
}
