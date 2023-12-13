package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.APIResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.WeightUnitRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.WeightUnitResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.WeightUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<WeightUnitResponseDto> getAllWeightUnit() {
        return weightUnitService.getAllWeightUnit();
    }

    @GetMapping("/{id}")
    public WeightUnitResponseDto getWeightUnitById(@PathVariable Long id) {
        return weightUnitService.getWeightUnitById(id);
    }

    @PutMapping("/editeWeightUnit")
    public WeightUnitResponseDto editeWeightUnit(@RequestBody WeightUnitResponseDto weightUnitResponseDto, Long id) throws MasterException {
        return weightUnitService.editeWeightUnit(weightUnitResponseDto, id);
    }

    @DeleteMapping
    public void deleteTags(@RequestParam Long id) {
        weightUnitService.deleteWeightUnit(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<WeightUnitResponseDto>> getTagsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<WeightUnitResponseDto> WeightUnitWithPagination = weightUnitService.getWeightUnitPagination(offset, pageSize);
        return new APIResponse<>(WeightUnitWithPagination.getSize(), WeightUnitWithPagination);
    }
}
