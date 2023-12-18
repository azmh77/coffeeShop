package com.rhpm.coffeeShop.model.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean emailConfirmation;
    private String phoneNumber;
    private Boolean phoneNumberConfirmation;
    private String nationalCode;
    private String state;
    private String city;
    private String address;
    private String zipCode;
    private String currentWalletBalance;
    private String role;
    private Boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime RegisterDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastPurchase;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastEmailChange;
    private byte incorrectLoginCount;
    private byte[] profileImgUrl;
    private String profileImgName;
    private String CSID;
}
