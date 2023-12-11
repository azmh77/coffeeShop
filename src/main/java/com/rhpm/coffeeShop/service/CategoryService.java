package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) throws MasterException;
}
