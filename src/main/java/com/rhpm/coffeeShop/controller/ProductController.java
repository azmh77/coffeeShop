package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.ProductRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.ProductResponseDto;
import com.rhpm.coffeeShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/createProduct")
    public ProductResponseDto createProduct(@ModelAttribute ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }
}
