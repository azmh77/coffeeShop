package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.APIResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.BrandRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/createCategory")
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto) throws MasterException {
        return categoryService.createCategory(categoryRequestDto);
    }

    @GetMapping()
    public List<CategoryResponseDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/editeCategory")
    public CategoryResponseDto editeCategory(@RequestBody CategoryRequestDto categoryRequestDto, Long id) throws MasterException {
        return categoryService.editeCategory(categoryRequestDto,id);
    }

    @DeleteMapping
    public void deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<CategoryResponseDto>> getCategoryWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<CategoryResponseDto> categoryWithPagination = categoryService.getCategoryWithPagination(offset, pageSize);
        return new APIResponse<>(categoryWithPagination.getSize(), categoryWithPagination);
    }
}
