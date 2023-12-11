package com.rhpm.coffeeShop.model.dto.requestDto;

import com.rhpm.coffeeShop.model.entity.CategoryEntity;
import com.rhpm.coffeeShop.model.entity.TagEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProductRequestDto {
    private String title;
    private String description;
    private Long brandId;
    private String price;
    private Long Weight;
    private String productType;
    private List<TagEntity> tag;
    private Integer inventoryCount;
    private List<MultipartFile> profilePic;
    private Boolean discount;
    private Long discountId;
    private Long userCreatedId;
    private List<CategoryEntity> category;
}
