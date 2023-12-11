package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagService implements com.rhpm.coffeeShop.service.TagService {
    private final TagRepository tagRepository;

    @Override
    public TagResponseDto createTag(TagRequestDto tagRequestDto) {
        return null;
    }
}
