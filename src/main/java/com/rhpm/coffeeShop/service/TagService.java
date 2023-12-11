package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

import java.io.IOException;

public interface TagService {
    TagResponseDto createTag(TagRequestDto tagRequestDto) throws MasterException, IOException;
}
