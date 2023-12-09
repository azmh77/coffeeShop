package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;

@Data
public class UserAuthRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
