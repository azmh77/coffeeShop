package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.BrandRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface BrandService {
    BrandResponseDto createBrand(BrandRequestDto brandRequestDto) throws MasterException, IOException;

    List<BrandResponseDto> getAllBrand();

    BrandResponseDto getBrandById();

    BrandResponseDto editeBrand();

    void deleteBrand();

    Page<BrandResponseDto> getBrandWithPagination(int offset, int pageSize);
}
