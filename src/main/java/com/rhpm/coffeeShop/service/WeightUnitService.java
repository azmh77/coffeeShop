package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.WeightUnitRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WeightUnitResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WeightUnitService {
    WeightUnitResponseDto createWeightUnit(WeightUnitRequestDto weightUnitRequestDto) throws MasterException;

    List<WeightUnitResponseDto> getAllWeightUnit();

    WeightUnitResponseDto getWeightUnitById(Long id);

    WeightUnitResponseDto editeWeightUnit(WeightUnitResponseDto weightUnitResponseDto, Long id);

    void deleteWeightUnit(Long id);

    Page<WeightUnitResponseDto> getWeightUnitPagination(int offset, int pageSize);
}
