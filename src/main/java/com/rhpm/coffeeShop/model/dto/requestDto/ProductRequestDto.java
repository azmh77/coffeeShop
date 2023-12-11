package com.rhpm.coffeeShop.model.dto.requestDto;

import com.rhpm.coffeeShop.model.entity.CategoryEntity;
import com.rhpm.coffeeShop.model.entity.PropertyEntity;
import com.rhpm.coffeeShop.model.entity.TagEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProductRequestDto {
    private String title;
    private String description;
    private Integer brandId;
    private String price;
    private Integer Weight;
    private String productType;
    private List<TagEntity> tag;
    private Integer inventoryCount;
    private MultipartFile profilePic;
    private Boolean discount;
    private Integer discountId;
    private Integer likeCount;
    private Integer userCreatedId;
    private List<PropertyEntity> propertys;
    private List<CategoryEntity> category;
}
