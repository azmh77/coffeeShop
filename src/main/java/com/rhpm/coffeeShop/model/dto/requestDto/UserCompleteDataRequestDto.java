package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserCompleteDataRequestDto {
    private String phoneNumber;
    private String nationalCode;
    private String state;
    private String city;
    private String address;
    private String zipCode;
    private MultipartFile profilePic;
    private Long userId;
}
