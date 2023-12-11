package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.BrandRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping("/createBrand")
    public BrandResponseDto createBrand(@ModelAttribute BrandRequestDto brandRequestDto) throws MasterException, IOException {
        return brandService.createBrand(brandRequestDto);
    }
}
