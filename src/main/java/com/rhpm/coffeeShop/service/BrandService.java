package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.BrandRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.BrandResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

import java.io.IOException;

public interface BrandService {
    BrandResponseDto createBrand(BrandRequestDto brandRequestDto) throws MasterException, IOException;
}
