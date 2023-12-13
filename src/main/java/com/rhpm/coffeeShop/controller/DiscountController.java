package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.APIResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.CategoryRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CategoryResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/product/discount")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @PostMapping("/createDiscount")
    public DiscountResponseDto createDiscount(@RequestBody DiscountRequestDto discountRequestDto) throws MasterException, IOException {
        return discountService.createDiscount(discountRequestDto);
    }

    @GetMapping()
    public List<DiscountResponseDto> getAllDiscount() {
        return discountService.getAllDiscount();
    }

    @GetMapping("/{id}")
    public DiscountResponseDto getDiscountById(@PathVariable Long id) {
        return discountService.getDiscountById(id);
    }

    @PutMapping("/editeDiscount")
    public DiscountResponseDto editeDiscount(@RequestBody DiscountRequestDto discountRequestDto, Long id) throws MasterException {
        return discountService.editeDiscount(discountRequestDto,id);
    }

    @DeleteMapping
    public void deleteDiscount(@RequestParam Long id) {
        discountService.deleteDiscount(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<DiscountResponseDto>> getDiscountWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<DiscountResponseDto> discountWithPagination = discountService.getDiscountWithPagination(offset, pageSize);
        return new APIResponse<>(discountWithPagination.getSize(), discountWithPagination);
    }
}
