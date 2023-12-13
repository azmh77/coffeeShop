package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface TagService {
    TagResponseDto createTag(TagRequestDto tagRequestDto) throws MasterException, IOException;

    List<TagResponseDto> getAllTags();

    TagResponseDto getTagsById(Long id);

    TagResponseDto editeTags(TagResponseDto tagResponseDto, Long id);

    void deleteTags(Long id);

    Page<TagResponseDto> getTagsWithPagination(int offset, int pageSize);
}
