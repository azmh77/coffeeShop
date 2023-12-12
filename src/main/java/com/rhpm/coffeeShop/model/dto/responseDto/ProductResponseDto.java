package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long brandId;
    private String price;
    private Long Weight;
    private String productType;
    private List<TagResponseDto> tag;
    private Long inventoryCount;
    private byte[] productImgUrl;
    private String productImgName;
    private Boolean isEnable;
    private Boolean discount;
    private Long likeCount;
    private Long commentCount;
    private Long userCreatedId;
    private List<UserResponseDto> usersLiked;
    //    private List<CommentEntity> comments;
    private Long viewCount;
    private Boolean adminView;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long sellCount;
    private List<CategoryResponseDto> category;
    private String weightUnit;
}
