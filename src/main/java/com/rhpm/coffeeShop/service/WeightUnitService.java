package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.WeightUnitRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WeightUnitResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

public interface WeightUnitService {
    WeightUnitResponseDto createWeightUnit(WeightUnitRequestDto weightUnitRequestDto) throws MasterException;
}
