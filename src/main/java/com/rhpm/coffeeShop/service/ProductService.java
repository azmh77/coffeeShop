package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.ProductRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
}
