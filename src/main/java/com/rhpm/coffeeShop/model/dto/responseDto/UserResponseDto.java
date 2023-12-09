package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean emailConfirmation;
    private String password;
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
    private Date RegisterDate;
    private Date lastPurchase;
    private Date lastPasswordChange;
    private Date lastEmailChange;
    private List<OldUserPasswordResponseDto> oldUserPasswords;
    private List<OldUserEmailResponseDto> oldUserEmails;
    private byte incorrectLoginCount;
    private byte[] profileImgUrl;
    private String profileImgName;
}
