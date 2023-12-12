package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.WeightUnitRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WeightUnitResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.WeightUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/weightUnit")
@CrossOrigin("*")
@RequiredArgsConstructor
public class WeightUnitController {
    private final WeightUnitService weightUnitService;

    @PostMapping("/createWeightUnit")
    public WeightUnitResponseDto createWeightUnit(@RequestBody WeightUnitRequestDto weightUnitRequestDto) throws MasterException {
        return weightUnitService.createWeightUnit(weightUnitRequestDto);
    }
}
