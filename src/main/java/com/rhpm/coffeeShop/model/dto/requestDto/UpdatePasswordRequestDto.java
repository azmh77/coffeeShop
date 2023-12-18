package com.rhpm.coffeeShop.model.dto.requestDto;

import lombok.Data;

@Data
public class UpdatePasswordRequestDto {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private Long userId;
}
