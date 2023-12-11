package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BrandRequestDto {
    private String brandName;
    private String brandAbout;
    private MultipartFile brandPic;
    private Long userCreateId;
}
