package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.APIResponse;
import com.rhpm.coffeeShop.model.dto.requestDto.DiscountRequestDto;
import com.rhpm.coffeeShop.model.dto.requestDto.TagRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.DiscountResponseDto;
import com.rhpm.coffeeShop.model.dto.responseDto.TagResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/tag")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping("/createTag")
    public TagResponseDto createTag(@ModelAttribute TagRequestDto tagRequestDto) throws MasterException, IOException {
        return tagService.createTag(tagRequestDto);
    }

    @GetMapping()
    public List<TagResponseDto> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public TagResponseDto getTagsById(@PathVariable Long id) {
        return tagService.getTagsById(id);
    }

    @PutMapping("/editeTags")
    public TagResponseDto editeTags(@RequestBody TagResponseDto tagResponseDto, Long id) throws MasterException {
        return tagService.editeTags(tagResponseDto, id);
    }

    @DeleteMapping
    public void deleteTags(@RequestParam Long id) {
        tagService.deleteTags(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<TagResponseDto>> getTagsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<TagResponseDto> TagsWithPagination = tagService.getTagsWithPagination(offset, pageSize);
        return new APIResponse<>(TagsWithPagination.getSize(), TagsWithPagination);
    }
}
