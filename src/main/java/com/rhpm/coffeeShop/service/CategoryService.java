package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) throws MasterException;

    List<CategoryResponseDto> getAllCategory();

    CategoryResponseDto getCategoryById();

    CategoryResponseDto editeCategory();

    void deleteCategory();

    Page<CategoryResponseDto> getCategoryWithPagination(int offset, int pageSize);
}
