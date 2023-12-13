package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface DiscountService {
    DiscountResponseDto createDiscount(DiscountRequestDto discountRequestDto) throws MasterException, IOException;

    List<DiscountResponseDto> getAllDiscount();

    DiscountResponseDto getDiscountById(Long id);

    DiscountResponseDto editeDiscount(DiscountRequestDto discountRequestDto, Long id);

    void deleteDiscount(Long id);

    Page<DiscountResponseDto> getDiscountWithPagination(int offset, int pageSize);
}
