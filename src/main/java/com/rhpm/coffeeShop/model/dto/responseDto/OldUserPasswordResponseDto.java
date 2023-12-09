package com.rhpm.coffeeShop.model.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class OldUserPasswordResponseDto {
    private Long id;
    private String oldPassword;
    private String newPassword;
    private Date passwordChangeDate;
    private Long userId;
}
