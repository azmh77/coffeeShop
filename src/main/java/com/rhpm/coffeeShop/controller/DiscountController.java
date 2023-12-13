package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/discount")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @PostMapping("/createDiscount")
    public DiscountResponseDto createDiscount(@RequestBody DiscountRequestDto discountRequestDto) throws MasterException, IOException {
        return discountService.createDiscount(discountRequestDto);
    }
}
