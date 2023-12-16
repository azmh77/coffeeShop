package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.ProductRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.ProductResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/createProduct")
    public ProductResponseDto createProduct(@ModelAttribute ProductRequestDto productRequestDto) throws MasterException, IOException {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) throws MasterException {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/likeProduct")
    public void likeProduct(@RequestParam Long userId, @RequestParam Long productId) throws MasterException {
        productService.likeProduct(userId, productId);
    }

    @GetMapping("/usersLiked")
    public List<UserResponseDto> getAllUsersLiked(@RequestParam Long productId) throws MasterException {
        return productService.getAllUsersLiked(productId);
    }
}
