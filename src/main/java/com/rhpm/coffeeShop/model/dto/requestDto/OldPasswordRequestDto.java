package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;

@Data
public class OldPasswordRequestDto {
    private String oldPassword;
    private String newPassword;
    private Long userId;
}
