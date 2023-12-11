package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

@Data
public class BrandResponseDto {
    private Long id;
    private String brandName;
    private String brandAbout;
    private byte[] brandImgUrl;
    private String brandImgName;
    private Long userCreateId;
}
