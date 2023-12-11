package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;

public interface TagService {
    TagResponseDto createTag(TagRequestDto tagRequestDto);
}
