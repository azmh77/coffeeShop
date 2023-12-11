package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.dto.requestDto.ProductRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.ProductResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements com.rhpm.coffeeShop.service.ProductService {
    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        return null;
    }
}
