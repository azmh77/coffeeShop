package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

@Data
public class CommentResponseDto {
    private Long id;
    private String body;
    private Long userId;
    private Long productId;
}
