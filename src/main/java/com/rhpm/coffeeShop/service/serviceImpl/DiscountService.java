package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.repository.DiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiscountService implements com.rhpm.coffeeShop.service.DiscountService {
    private final DiscountRepository discountRepository;

    @Override
    public DiscountResponseDto createDiscount(DiscountRequestDto discountRequestDto) {
        return null;
    }
}
