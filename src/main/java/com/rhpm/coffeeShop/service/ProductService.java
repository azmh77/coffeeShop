package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.ProductRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.ProductResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequestDto) throws MasterException, IOException;

    ProductResponseDto getProductById(Long id) throws MasterException;

    void likeProduct(Long userId, Long productId) throws MasterException;

    List<UserResponseDto> getAllUsersLiked(Long productId) throws MasterException;
}
