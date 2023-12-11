package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/createCategory")
    public CategoryResponseDto createCategory(@ModelAttribute CategoryRequestDto categoryRequestDto) throws MasterException {
        return categoryService.createCategory(categoryRequestDto);
    }
}
