package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tag")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping("/createTag")
    public TagResponseDto createTag(@ModelAttribute TagRequestDto tagRequestDto) {
        return tagService.createTag(tagRequestDto);
    }
}
