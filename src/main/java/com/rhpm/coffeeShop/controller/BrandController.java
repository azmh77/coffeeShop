package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.APIResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.BrandRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.UserResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/product/brand")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping("/createBrand")
    public BrandResponseDto createBrand(@ModelAttribute BrandRequestDto brandRequestDto) throws MasterException, IOException {
        return brandService.createBrand(brandRequestDto);
    }

    @GetMapping()
    public List<BrandResponseDto> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/{id}")
    public BrandResponseDto getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/editeBrand")
    public BrandResponseDto editeBrand(@ModelAttribute BrandRequestDto brandRequestDto, Long id) throws MasterException, IOException {
        return brandService.editeBrand(brandRequestDto,id);
    }

    @DeleteMapping
    public void deleteBrand(@RequestParam Long id) {
        brandService.deleteBrand(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<BrandResponseDto>> getBrandWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<BrandResponseDto> brandWithPagination = brandService.getBrandWithPagination(offset, pageSize);
        return new APIResponse<>(brandWithPagination.getSize(), brandWithPagination);
    }
}
