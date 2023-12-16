package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;

@Data
public class CommentRequestDto {
    private String body;
    private Long parentId;
    private Long userId;
    private Long productId;
}
